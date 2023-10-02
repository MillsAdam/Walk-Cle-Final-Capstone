<template>
  <div>
    
    <!-- <input type="text" name="location" :value="location.coordinates" disabled /> -->
    <button @click="addMarkersAndPopups">dkkdksakdlakd;kasdksakdlkaslkdkas;da</button><button @click="addCoffee">POI</button><button @click="addParks">parks</button><button  @click="removeMarkersAndPopups">Remove Markers</button> <button @click="addBars">BAR</button>
    <div id="map"></div>
    <!-- <button class="btn" @click="requestLocation">Get Current Location</button>-->
    
  </div>
</template>
  
<script>
import mapboxgl from "mapbox-gl";
import { MapboxSearchBox } from "@mapbox/search-js-web";
import * as turf from "@turf/turf";
import MapboxDirections from "@mapbox/mapbox-gl-directions/dist/mapbox-gl-directions";
import "@mapbox/mapbox-gl-directions/dist/mapbox-gl-directions.css";
import service from '../services/locationService.js'
// const mapboxgl = require("mapbox-gl/dist/mapbox-gl.js");
// Retrieve API key from environment variables
mapboxgl.accessToken = process.env.VUE_APP_MAPBOX_KEY;

export default {
  data() {
    return {
      map: null,
      query: "",
      location: {
        type: "Point",
        coordinates: [],
      },
      markers: [],
      stadiums: [],
      Bars: [],
      parks: [],
      poi: [],
      coffee: [],
       popupTexts: [
        "This is the first marker's www.google.com",
        "This is the second marker's custom text.",
        // Add more custom texts here, one for each marker
      ],
      searchBox: null,
      userLocation: {
        lat: 0,
        lng: 0,
      },
      created(){
        this.stadiums = service.getAllLocations().then(
          (rep) =>{ 
            this.stadiums = rep.data;
          }
        )
      }
    };
  },
  methods: {
    initMap() {
      // Create map object
      this.map = new mapboxgl.Map({
        container: "map",
        style: "mapbox://styles/walkcle216/cln4qqvn306wt01qi05mi9h14",
        center: [this.userLocation.lng, this.userLocation.lat],
        zoom: 15,
      });

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
      const marker = new mapboxgl.Marker({ color: "blue" })
        .setLngLat(lngLat)
        .addTo(this.map);
      this.markers.push(marker);
    },
    removeMapMarkers() {
      this.markers.forEach((marker) => marker.remove());
      this.markers = [];
    },
    setLocation(lngLat) {
      this.removeMapMarkers();
      this.addMapMarker(lngLat);
      this.setLocationCoordinates(lngLat);
    },
    requestLocation() {
      // Request to get the user's current location
      navigator.geolocation.getCurrentPosition((position) => {
        // get the latitude and longitude returned
        const lat = position.coords.latitude;
        const lng = position.coords.longitude;

        // set location data
        this.setLocation({ lng, lat });

        // move the ap to show the location
        this.map.flyTo({ center: [lng, lat], zoom: 15 });

        // Store user location
        this.userLocation.lat = lat;
        this.userLocation.lng = lng;

        // Add a marker for the current location
        this.addMapMarker({ lng, lat });
      });
    },
    getDirections() {
      // Set up Mapbox Directions control
      const directions = new MapboxDirections({
        accessToken: mapboxgl.accessToken,
        unit: "imperial",
        profile: "mapbox/walking",
      });
      directions.setOrigin([this.userLocation.lng, this.userLocation.lat]);
      this.map.addControl(directions, "bottom-left");
    },
    search() {
      // Set up Mapbox Search Box
      const point = turf.point([this.userLocation.lng, this.userLocation.lat]);
      const options = { units: "miles" };
      const radius = 5; // 1 mile
      const bbox = turf.bbox(turf.buffer(point, radius, options));

      const searchBox = new MapboxSearchBox();
      searchBox.accessToken = mapboxgl.accessToken;
      searchBox.options = {
        language: "en",
        country: "us",
        bbox: bbox,
      };

      // searchBox.on('result', (result) => {
      //     const { lng, lat } = result.result.geometry.coordinates;
      //     this.addMapMarker({ lng, lat });
      //     this.getDirections({ lng, lat });
      // });

      this.map.addControl(searchBox);
    },
    navigation() {
      // Adds basic zoom and rotation control
      this.map.addControl(new mapboxgl.NavigationControl());
    },
    geoLocate() {
      // Adds Location control
      const geolocateControl = new mapboxgl.GeolocateControl({
        positionOptions: {
          enableHighAccuracy: true,
        },
        trackUserLocation: true,
        showUserLocation: true,
      });
      geolocateControl.on("geolocate", (e) => {
        const lat = e.coords.latitude;
        const lng = e.coords.longitude;
        this.addMapMarker({ lng, lat });
      });
      this.map.addControl(geolocateControl);
    },
     
     addSports() {
      const coordinates = this.stadiums.longitude

      console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();
      this.map.flyTo({ center: [-81.6852949, 41.490645], zoom: 15 });

      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Create a popup with custom content
                const popupContent = `
              <div>
                <p>${this.popupTexts[index]}</p>
                <a href="https://www.google.com" target="_blank">Visit Google</a>
                <img src="@/assets/logo/small.png" alt="Image" width="200"/>
                <button id="checkInBtn${index}" class="check-in-button">Check-In</button>
              </div>
            `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        // Attach a click event handler to the check-in button
        // const checkInBtn = document.getElementById(`checkInBtn${index}`);
        // checkInBtn.addEventListener("click", () => {
        //   // Handle the check-in action here (e.g., show a confirmation dialog)
        //   alert("Checked in!");
        // });

        this.stadiums.push(marker);
      });
    },
    
    addBars() {
  const coordinates = [
    [-81.7037735,41.4986853],
    [-81.6900132,41.4991465],
    [-81.6991611,41.5005667],
    [-81.698024,41.492705],
    [-81.7045326,41.4844029]
     // Replace with your desired coordinates
    // Add more coordinates here
  ];

  // Debugging: Log the coordinates array
   // Debugging: Log the coordinates array
      console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();
      this.map.flyTo({ center: [-81.6852949, 41.490645], zoom: 15 });
      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Create a popup with custom content
        const popupContent = `
          <div>
            <p>${this.popupTexts[index]}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200"/>
            <button id="checkInBtn${index}" class="check-in-button">Check-In</button>
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.markers.push(marker);
      });
    },
    fetchDataFromAPI() {
      // Assuming 'service.getAllLocations()' is an asynchronous function that returns a promise
      service.getAllLocations()
        .then((response) => {
          // Assuming the response contains an array of locations
          this.locations = response.data;
        })
        .catch((error) => {
          console.error('Error fetching locations:', error);
        });
    },
   fetchDataFroStadiums() {
      // Assuming 'service.getAllLocations()' is an asynchronous function that returns a promise
      service.getAllStadiums()
        .then((response) => {
          // Assuming the response contains an array of locations
          this.stadium = response.data;
        })
        .catch((error) => {
          console.error('Error fetching locations:', error);
        });
    },
   






    addMarkersAndPopups() {
    this.locations.forEach((location) => {
      const { locationName, locationLatitude, locationLongitude } = location;

      // Create a marker at the specified location
      const stadiums = new mapboxgl.Marker({ color: "blue" })
        .setLngLat([locationLongitude, locationLatitude])
        .addTo(this.map);

      // Create a popup with custom content
      const popupContent = `
        <div>
          <p>${locationName}</p>
          <p>${locationLatitude}</p>
          <button id="checkInBtn${this.locationId}" class="check-in-button">Check-In</button>
        </div>
      `;

      const popup = new mapboxgl.Popup({ offset: 25 })
        .setHTML(popupContent);

      // Attach the popup to the marker
      stadiums.setPopup(popup);
    });
  },
    addParks() {
      const coordinates = [
        [-81.7138946, 41.4991564],
        [-81.7013211, 41.4966056],
        // Add more coordinates here
      ];

      // Debugging: Log the coordinates array
      console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();
      this.map.flyTo({ center: [-81.6852949, 41.490645], zoom: 15 });
      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
       const popupContent = `
          <div>
            <p>${this.popupTexts[index]}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200"/>
            <button id="checkInBtn${index}" class="check-in-button">Check-In</button>
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.parks.push(marker);
        
      });
    },
    addPOI() {
  const coordinates = [
    [-81.6852949,41.4958921],
    [-81.6995481,41.5060535],
    [-81.6880574,41.4965474],
     [-81.7037735,41.4986853],
    [-81.6900132,41.4991465],
    [-81.6991611,41.5005667],
    [-81.698024,41.492705],
    [-81.7045326,41.4844029],
    [-81.7138946,41.4991564],
    [-81.7013211,41.4966056],

     // Replace with your desired coordinates
    // Add more coordinates here
  ];

 console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();
      this.map.flyTo({ center: [-81.6852949, 41.490645], zoom: 15 });
      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
        const popupContent = `
          <div>
            <p>${this.popupTexts[index]}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200"/>
            <button id="checkInBtn${index}" class="check-in-button">Check-In</button>
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.markers.push(marker);
      });
    },
    addCoffee() {
  const coordinates = [
    [-81.7147703,41.4801392],
    [-81.7089057,41.4841798],
    [-81.6895095,41.4798316],
    [-81.6909685,41.5007669],
    [-81.7041667,41.4841667],
    [-81.6746106,41.5040237],
    [-81.6882329,41.5015518],
    [-81.7104054,41.489191],
    [-81.6994828,41.4993248],

     // Replace with your desired coordinates
    // Add more coordinates here
  ];

 console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();
      this.map.flyTo({ center: [-81.6852949, 41.490645], zoom: 15 });
      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
        const popupContent = `
          <div>
            <p>${this.popupTexts[index]}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200"/>
            <button id="checkInBtn${index}" class="check-in-button">Check-In</button>
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.coffee.push(marker);
      });
    },
    removeMarkersAndPopups() {
  this.markers.forEach((marker) => {
    marker.remove();
    
  });
  this.stadiums.forEach((poi) =>{
    poi.remove();
  })
  this.Bars.forEach((poi) =>{
    poi.remove();
  })
  this.parks.forEach((poi) =>{
    poi.remove();
  })
  this.poi.forEach((poi) =>{
    poi.remove();
  })
  this.coffee.forEach((poi) =>{
    poi.remove();
  })
  this.parks = [];
  this.Bars = [];
  this.poi = [];
  this.markers = [];
  this.coffee = [];
  
    },
  },
  mounted() {
    navigator.geolocation.getCurrentPosition((position) => {
      const lat = position.coords.latitude;
      const lng = position.coords.longitude;
      this.userLocation = { lat, lng };
      this.initMap();
      this.map.flyTo({ center: [lng, lat], zoom: 15 });
      this.addMapMarker({ lng, lat });

      this.getDirections();
      this.search();
      this.navigation();
      this.geoLocate();
      this.fetchDataFromAPI(); 
    });
  },
};
</script>
  
<style scoped>
#map {
  width: 100vw;
  height: 100%;
}

.mapbox-directions-instructions {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  font-family: "Urbanist", sans-serif;
  font-size: 14px;
  color: #333;
}

.mapbox-directions-route-summary {
  font-family: "Urbanist", sans-serif;
}

.mapbox-directions-step {
  margin-bottom: 5px;
}

.mapbox-directions-step-number {
  font-weight: bold;
  color: #0078d4;
}

.mapbox-directions-step-text {
  color: #000000;
}
</style>