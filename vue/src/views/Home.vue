<template>
  <div class="map-container">
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
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [-81.6934, 41.4993], // Cleveland, Ohio coordinates
      zoom: 12,
    });

    // Add map controls, markers, and other customizations here

    // Enable map dragging/panning
    this.map.dragPan.enable();
  },
};
</script>

<style>
.map-container {
  width: 100%;
  height: 400px;
  overflow: auto; /* Add a scrollbar when the map exceeds the container's height */
}

#map {
  width: 100%;
  height: 100%;
}
</style>