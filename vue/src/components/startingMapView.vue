<template>
  <div>
    <head>
      <meta charset="utf-8" />
      <title>Getting started with the Mapbox Directions API</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <script src="https://api.tiles.mapbox.com/mapbox-gl-js/v2.14.1/mapbox-gl.js"></script>
      <link
        href="https://api.tiles.mapbox.com/mapbox-gl-js/v2.14.1/mapbox-gl.css"
        rel="stylesheet"
      />
    </head>
    <div id="map" style="position: absolute; width: 100%; height: 100%"></div>
  </div>
</template>

<script>
const ACCESS_TOKEN = "pk.eyJ1Ijoid2Fsa2NsZTIxNiIsImEiOiJjbG16MGVvdWkxM2QzMm9wNjNobm9hZGQyIn0.5r382ZeMc0zOhHpiAd9D2A";

mapboxgl.accessToken = ACCESS_TOKEN;
const map = new mapboxgl.Map({
  container: "map",
  style: "mapbox://styles/mapbox/streets-v12",
  center: [-73.99209, 40.68933],
  zoom: 8.8,
});

const searchJS = document.getElementById("search-js");
searchJS.onload = function () {
  const searchBox = new MapboxSearchBox();
  searchBox.accessToken = ACCESS_TOKEN;
  searchBox.options = {
    types: "address,poi",
    proximity: [-73.99209, 40.68933],
  };
  searchBox.marker = true;
  searchBox.mapboxgl = mapboxgl;
  map.addControl(searchBox);
};
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