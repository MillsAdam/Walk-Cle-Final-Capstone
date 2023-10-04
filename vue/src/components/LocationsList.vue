<template>
    <div class="container">
        <ul>
            <li v-for="location in locations" :key="location.id">
                <!-- {{ location.locationId }} |  -->
                {{ location.locationTypeName }} | 
                {{ location.locationName }} | 
                {{ location.locationLatitude }} | 
                {{ location.locationLongitude }} | 
                <button @click="viewLocation(location.locationId)">View Location</button>
            </li>
        </ul>
        <ul>
            <li v-for="locationType in locationTypes" :key="locationType.id">
                <!-- {{ locationType.locationTypeId }} |  -->
                {{ locationType.locationTypeName }} | 
                <button @click="viewLocations(locationType.locationTypeId)">View Location Type</button>
            </li>
        </ul>
    </div>
</template>

<script>
import locationService from '../services/locationService.js';
import locationTypeService from '../services/locationTypeService.js';

export default {
    name: 'locations-list',
    data() {
        return {
            locations: [],
            locationTypes: [],
        };
    },
    methods: {
        viewLocation(locationId) {
            this.$router.push(`locations/id/${locationId}`);
        },
        viewLocationType(locationTypeId) {
            this.$router.push(`locationtypes/id/${locationTypeId}`);
        },
    },
    created() {
        locationService.getAllLocations().then( response => {
            this.locations = response.data;
        });
        locationTypeService.getAllLocationTypes().then (response => {
            this.locationTypes = response.data;
        });
    },
}
</script>

<style scoped>

</style>