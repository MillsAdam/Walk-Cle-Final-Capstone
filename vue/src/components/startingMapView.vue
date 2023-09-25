<template>
<div>
  <head>
    <meta charset='utf-8' />
    <title>Getting started with the Mapbox Directions API</title>
    <meta name='viewport' content='width=device-width, initial-scale=1' />
    <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v2.14.1/mapbox-gl.js'></script>
    <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v2.14.1/mapbox-gl.css' rel='stylesheet' />
  </head>
    <div id='map'></div>
  </div>
</template>

<script>
// eslint-disable-next-line no-undef
mapboxgl.accessToken = 'pk.eyJ1Ijoid2Fsa2NsZTIxNiIsImEiOiJjbG16MGVvdWkxM2QzMm9wNjNobm9hZGQyIn0.5r382ZeMc0zOhHpiAd9D2A';
export default {
  data() {
    const bounds = [
      [-123.069003, 45.395273],
      [-122.303707, 45.612333]
    ];

    // eslint-disable-next-line no-undef
    const map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/mapbox/streets-v12',
      center: [-122.662323, 45.523751], // starting position
      zoom: 12
    });

    map.setMaxBounds(bounds);

    const start = [-122.662323, 45.523751];

    return { bounds, map, start };
  },
  created() {
    // Add any code you want to run when the component is created
  }
}
</script>

<style>
body {
        margin: 0;
        padding: 0;
      }

      #map {
        position: absolute;
        top: 0;
        bottom: 0;
        width: 100%;
      }
</style>