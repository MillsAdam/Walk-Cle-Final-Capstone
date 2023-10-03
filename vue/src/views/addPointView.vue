<template>
  <div class="container">
       <h1>Add a New Point</h1>
    <LocationForm />
  <div class="footer-container">
      <FooterComp />
    </div>
    </div>
</template>

<script>
import LocationForm from "../components/locationForm.vue"
import FooterComp from '../components/FooterComp.vue';
export default {
    components: {
        LocationForm,
        FooterComp
    }
}
</script>

<style>

</style>