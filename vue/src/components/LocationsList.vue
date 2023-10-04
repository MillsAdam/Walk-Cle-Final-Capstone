<template>
    <div class="container">
        <ul>
            <li v-for="location in locations" :key="location.id">
                <!-- {{ location.locationId }} |  -->
                <!-- {{ location.locationTypeName }} |  -->
                {{ location.locationName }} | 
                <!-- {{ location.locationLatitude }} |  -->
                <!-- {{ location.locationLongitude }} |  -->
                <button @click="viewLocation(location.locationId)">Checkin</button>
            </li>
        </ul>
    </div>
</template>

<script>
import locationService from '../services/locationService.js';
import locationTypeService from '../services/locationTypeService.js';
import CheckInService from '../services/CheckInService.js';

export default {
    name: 'locations-list',
    data() {
        return {
            locations: [],
            locationTypes: [],
            checkins: [],
        };
    },
    methods: {
        addCheckin(amount) {
            this.$store.commit("INCREASE_CHECKINS", amount);
        },
    },
    created() {
        locationService.getAllLocations().then( response => {
            this.locations = response.data;
        });
        locationTypeService.getAllLocationTypes().then (response => {
            this.locationTypes = response.data;
        });
        CheckInService.barCheckIn(this.$route.params.locationId).then (response => {
            this.checkins = response;
        });
    },
}
</script>

<style scoped>

</style>