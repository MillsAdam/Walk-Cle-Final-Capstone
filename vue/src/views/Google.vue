<template>
  <div class="container">
    <div class="map-container">
      <google-api/>
    </div>
    <div class="footer-container">
      <FooterComp />
    </div>
  </div>
</template>

<script>
import FooterComp from '../components/FooterComp.vue';
import googleApi from '../components/googleApi.vue';

export default {
  components: {
    googleApi,
    FooterComp
  },
};
</script>
<style>
.map-container {
  grid-area: map;
}

.footer-container {
  grid-area: footer;
}



.container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "map"
    "footer";
  justify-items: center;
  align-items: center;
  height: 100vh;
}


</style>