<template>
  <div class="map-container">
    <mapbox-search-box @search="searchLocation"/>
    <starting-map-view />
  </div>
</template>

<script>
import MapboxSearchBox from '../components/MapboxSearchBox.vue'
import startingMapView from '../components/startingMapView.vue'
export default {
  components: { 
    MapboxSearchBox,
    startingMapView 
    },
    methods: {
      searchLocation(location) {
        this.$refs.mapView.searchLocation(location);
      }
    }
    };
  
</script>

<style
    MapboxSearchBox>
</style>