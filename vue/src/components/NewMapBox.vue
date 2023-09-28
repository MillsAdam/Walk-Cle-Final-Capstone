<template>
    <div>
        <button @click="requestLocation">Get Current Location</button>
        <button @click="removeMapMarkers">Remove Markers</button>
        <form @submit.prevent="search">
            <input
                type="text"
                name="search-location"
                v-model="query"
                placeholder="Search"
            />
        </form>
        <input 
            type="text" 
            name="location" 
            :value="location.coordinates" 
            disabled 
        />
        <div id="map"></div>
    </div>
</template>
  
<script>
import mapboxgl from "mapbox-gl";
import { MapboxSearchBox } from "@mapbox/search-js-web";
import * as turf from '@turf/turf';

// const mapboxgl = require("mapbox-gl/dist/mapbox-gl.js");
// Retrieve API key from environment variables
// mapboxgl.accessToken = process.env.VUE_APP_MAPBOX_KEY;
  
export default {
    data() {
        return {
            // make environment variable
            ACCESS_TOKEN:
                "pk.eyJ1Ijoid2Fsa2NsZTIxNiIsImEiOiJjbG16MGVvdWkxM2QzMm9wNjNobm9hZGQyIn0.5r382ZeMc0zOhHpiAd9D2A",
            map: null,
            query: "",
            location: {
                type: "Point",
                coordinates: []
            }
        };
    },
    methods: {
        initMap() {
            // Create map object
            this.map = new mapboxgl.Map({
                container: "map",
                style: "mapbox://styles/mapbox/streets-v12",
                center: [-81.700058, 41.506035],
                zoom: 15,
            });

            // Adds basic zoom and rotation control
            this.map.addControl(new mapboxgl.NavigationControl());
            this.map.addControl(new mapboxgl.GeolocateControl({
                positionOptions: { enableHighAccuracy: true },
                trackUserLocation: true,
                showUserLocation: true,
            }));

            this.addMapClickListener();
        },
        addMapClickListener() {
            this.map.on("click", (e) => {
                this.setLocation(e.lngLat);
            });
        },
        setLocationCoordinates(lngLat) {
            this.setLocationCoordinates.coordinates = [
                Math.round(lngLat.lng * 10000) / 10000,
                Math.round(lngLat.lat * 10000) / 10000,
            ];
        },
        addMapMarker(lngLat) {
            // you can set a colour here to match your website's palette.
            new mapboxgl.Marker({ color: "blue" })
                .setLngLat(lngLat)
                .addTo(this.map);
        },
        removeMapMarkers() {
            const oldMarker = document.querySelector("mapboxgl-marker");
            if (oldMarker) {
                oldMarker.parentElement.removeChild(oldMarker);
            }
        },
        setLocation(lngLat) {
            this.removeMapMarkers();
            this.addMapMarker(lngLat);
            this.setLocationCoordinates(lngLat);
        },
        requestLocation() {
            // Request to get the user's current location
            window.navigator.geolocation.getCurrentPosition( (position) => {

                // get the latitude and longitude returned
                const lat = position.coords.latitude;
				const lng = position.coords.longitude;

                // set location data
                this.setLocation({ lng, lat });

                // move the ap to show the location
                this.map.flyTo({ center: [lng, lat], zoom: 15 });
            })
        },
        async search() {
            const response = await fetch(
                `
                    https://api.mapbox.com/geocoding/v5/mapbox.places/
                    ${this.query}.json?access_token=${this.ACCESS_TOKEN}
                `
            );
            this.query = "";
            const responseBody = await response.json();

            // Check we have at least 1 result
            if (responseBody.features.length == 0) {
                alert('no results found')
                return null;
            }

            const [lng, lat] = responseBody.features[0].center;
            this.setLocation({ lng, lat });
            this.map.flyTo({ center: [lng, lat], zoom: 15 });
        },
    },
    mounted() {
        this.initMap();

        mapboxgl.accessToken = this.ACCESS_TOKEN;
  
        let latitude, longitude;
  
        // Initialize the map at the user's location
        navigator.geolocation.getCurrentPosition((position) => {
            latitude = position.coords.latitude;
            longitude = position.coords.longitude;

  
            const point = turf.point([longitude, latitude]);
            const options = { units: 'miles' };
            const radius = 5; // 1 mile
            const bbox = turf.bbox(turf.buffer(point, radius, options));
  
            const searchBox = new MapboxSearchBox();
            searchBox.accessToken = this.ACCESS_TOKEN;
            searchBox.options = {
                language: 'en',
                country: 'us',
                bbox: bbox, // Set the bounding box in the search options
            };
  
            this.map.addControl(searchBox);
        });
    },
  };
</script>
  
<style scoped>
#map {
    width: 100%;
    height: 500px;
}
</style>