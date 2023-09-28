<template>
  <div class="container">
    <div class="map-container">
      <NewMapBox />
    </div>
    <div class="footer-container">
      <FooterComp />
    </div>
  </div>
</template>

<script>
import NewMapBox from '../components/NewMapBox.vue';
import FooterComp from '../components/FooterComp.vue';

export default {
  components: {
    NewMapBox,
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