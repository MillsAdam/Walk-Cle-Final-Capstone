<template>
  <div>
    <div id="map" style="position: absolute; width: 100%; height: 100%"></div>
    <button @click="getUserLocation" style="position: absolute; top: 10px; left: 10px;">Get My Location</button>
  </div>
</template>

<script>
import mapboxgl from 'mapbox-gl';
import MapboxGeocoder from '@mapbox/mapbox-gl-geocoder';

export default {
  data() {
    return {
      ACCESS_TOKEN: 'pk.eyJ1Ijoid2Fsa2NsZTIxNiIsImEiOiJjbG16MGVvdWkxM2QzMm9wNjNobm9hZGQyIn0.5r382ZeMc0zOhHpiAd9D2A',
    };
  },
  mounted() {
    mapboxgl.accessToken = this.ACCESS_TOKEN;
    const map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/mapbox/streets-v12',
      center: [-73.99209, 40.68933],
      zoom: 8.8,
    });

    // Add Geolocate Control
    const geolocate = new mapboxgl.GeolocateControl({
      positionOptions: {
        enableHighAccuracy: true,
      },
      trackUserLocation: true,
      showUserLocation: true,
    });

    map.addControl(
      new MapboxGeocoder({
        accessToken: this.ACCESS_TOKEN,
        mapboxgl: mapboxgl,
        types: 'address,poi',
        proximity: [-73.99209, 40.68933],
        marker: true,
      })
    );

    // Add the Geolocate Control to the map
    map.addControl(geolocate);

    // Event listener for geolocation update
    map.on('load', () => {
      geolocate.on('geolocate', (event) => {
        const { coords } = event;
        const { longitude, latitude } = coords;

        // Update the map's center to the user's location
        map.setCenter([longitude, latitude]);

        // Remove the previous user location marker if it exists
        if (this.userLocationMarker) {
          this.userLocationMarker.remove();
        }

        // Create a custom user location marker (blue arrow)
        this.userLocationMarker = new mapboxgl.Marker({
          color: '#007bff', // Blue color for the arrow
          rotation: event.coords.heading, // Use the heading to set the arrow's rotation
        })
          .setLngLat([longitude, latitude])
          .addTo(map);
      });
    });
  },
  methods: {
    getUserLocation() {
      // Trigger geolocation
      const geolocateButton = document.querySelector('.mapboxgl-ctrl-geolocate');
      if (geolocateButton) {
        geolocateButton.click();
      }
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 90%;
}
</style>
