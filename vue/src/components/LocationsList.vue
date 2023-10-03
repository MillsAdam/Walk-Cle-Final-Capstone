<template>
    <div class="container">
        <ul>
            <li v-for="location in locations" :key="location.id">
                <!-- {{ location.locationId }} |  -->
                {{ getLocationTypeName(location.locationTypeId) }} | 
                {{ location.locationName }} | 
                <!-- {{ location.locationLatitude }} | 
                {{ location.locationLongitude }} |  -->
                <button @click="viewLocation(location.locationId)">View Location</button>
            </li>
        </ul>
        <ul>
            <li v-for="locationType in locationTypes" :key="locationType.id">
                {{ locationType.locationTypeId }} | 
                {{ locationType.locationTypeName }} | 
                <button @click="viewLocations(locationType.locationTypeId)">View Locations</button>
            </li>
        </ul>
    </div>
</template>

<script>
import locationService from '../services/locationService';

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
        viewLocations(locationTypeId) {
            this.$router.push(`locationtypes/id/${locationTypeId}`);
        },
        getLocationTypeName(locationTypeId) {
            const locationType = this.locationTypes.find( type => type.locationTypeId === locationTypeId);
            return locationType ? locationType.locationTypeName : '';
        }
    },
    created() {
        locationService.getLocations().then( response => {
            this.locations = response.data;
        });
        locationService.getLocationTypes().then (response => {
            this.locationTypes = response.data;
        })
    },
}
</script>

<style scoped>

</style>