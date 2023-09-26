<template>
  <div class="map-container">
    <button @click="getUserLocation">Get My Location</button>
    <div id="map"></div>
    
  </div>
</template>

<script>
import mapboxgl from 'mapbox-gl';

export default {
  data() {
    return {
      map: null,
    };
  },
  mounted() {
    mapboxgl.accessToken = 'pk.eyJ1Ijoid2Fsa2NsZTIxNiIsImEiOiJjbG16MGVvdWkxM2QzMm9wNjNobm9hZGQyIn0.5r382ZeMc0zOhHpiAd9D2A';

    this.map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/mapbox/streets-v12',
      center: [-81.6934, 41.4993], // Default center (Cleveland, Ohio)
      zoom: 12,
    });

    // Add map controls, markers, and other customizations here

    // Enable map dragging/panning
    this.map.dragPan.enable();

    // Add GeolocateControl
    const geolocate = new mapboxgl.GeolocateControl({
      positionOptions: {
        enableHighAccuracy: true,
      },
      trackUserLocation: true,
      showUserLocation: true,
    });

    // Event listener for geolocation update
    this.map.on('load', () => {
      geolocate.on('geolocate', (event) => {
        const { coords } = event;
        const { longitude, latitude } = coords;

        // Update the map's center to the user's location
        this.map.setCenter([longitude, latitude]);
      });
    });
  },
  methods: {
    getUserLocation() {
      if ('geolocation' in navigator) {
        // Ask for user's permission
        navigator.geolocation.getCurrentPosition(
          (position) => {
            const { latitude, longitude } = position.coords;
            
            // Update the map's center to the user's location
            this.map.setCenter([longitude, latitude]);
            this.map.setZoom(15); 
            this.map.setMarker([longitude, latitude]);
          },
          (error) => {
            if (error.code === error.PERMISSION_DENIED) {
              alert('You denied the request for geolocation. Please enable location services in your browser settings.');
            } else {
              alert(`Geolocation error: ${error.message}`);
            }
          }
        );
      } else {
        alert('Geolocation is not available in your browser.');
      }
    },
  },
  
};
</script>

<style>
.map-container {
  width: 100%;
  height: 100vh;
 
}

#map {
  width: 100%;
  height: 100%;
}
</style>