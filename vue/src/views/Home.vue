<template>
  <div class="container">
    <div class="map-container">
      <map-with-search />
    </div>
    <div class="footer-container">
      <FooterComp />
    </div>
  </div>
</template>

<script>
import MapWithSearch from '../components/MapWithSearch.vue';
import FooterComp from '../components/FooterComp.vue';

export default {
  components: {
    MapWithSearch,
    FooterComp
  },
};
</script>
<style>
.map-container {
  grid-area: map;
  width: 100%;
  height: 90vh;
}

.footer-container {
  grid-area: footer;
}

#map {
  width: 100%;
  height: 90%;
}

.container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "map"
    "footer";
}


</style>