<template>
  <div class="container">
      <div class="rewards-container">
          <RewardsComp />
      </div>
      <div class="footer-container">
          <FooterComp />
      </div>
  </div>
</template>

<script>
import FooterComp from '../components/FooterComp.vue'
import RewardsComp from '../components/RewardsComp.vue'

export default {
    components: {
        FooterComp,
        RewardsComp
    }
}
</script>


<style scoped>
.container {
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
}

.rewards-container {
  flex-grow: 1;
  width: 100%;
  height: 90%;
}

.footer-container {
  background-color: #92b9c5;
  text-align: center;
  width: 100%;
  height: 10%;
}
</style>