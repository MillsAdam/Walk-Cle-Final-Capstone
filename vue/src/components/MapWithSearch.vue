<template>
    <div>
      <div id="map" style="position: absolute; width: 100%; height: 100%"></div>
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
  
      map.addControl(
        new MapboxGeocoder({
          accessToken: this.ACCESS_TOKEN,
          mapboxgl: mapboxgl,
          types: 'address,poi',
          proximity: [-73.99209, 40.68933],
          marker: true,
        })
      );
    },
  };
  </script>