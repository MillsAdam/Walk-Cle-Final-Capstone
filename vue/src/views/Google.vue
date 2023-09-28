<template>
  <div class="container">
    <div class="map-container">
      <google-api/>
    </div>
    <div class="footer-container">
    </div>
  </div>
</template>

<script>
import googleApi from '../components/googleApi.vue';

export default {
  components: {
    googleApi,
  },
};
</script>

<style>
.map-container {
  grid-area: map;
}


</style>