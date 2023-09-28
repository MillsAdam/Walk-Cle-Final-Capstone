<template>
  <div class="container">
    <div class="map-container">
      <map-with-search />
    </div>
    <div class="footer-container"></div>
  </div>
</template>

<script>
import MapWithSearch from '../components/MapWithSearch.vue';

export default {
  components: {
    MapWithSearch,
  },
};
</script>

<style>
/* .container {
  display: grid;
  grid-template-columns: 1fr;
  gap: 10px;
  grid-template-areas:
    "map"
    "footer";
  align-items: center;
  height: 100vh;
}

.map-container {
  grid-area: map;
}

.footer-container {
  grid-area: footer;
} */
</style>