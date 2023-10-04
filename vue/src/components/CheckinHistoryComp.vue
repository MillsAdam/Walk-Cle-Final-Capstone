<template>
    <div>
        <ul>
            <li v-for="checkin in checkins" :key="checkin.locationId">
                {{ checkin.locationId }}
            </li>
        </ul>
    </div>
</template>

<script>
import checkInService from '../services/CheckInService.js';

export default {
    name: 'checkin-history-comp',
    data() {
        return {
            checkins: [],
        }
    },
    created() {
        checkInService.barCheckIn(this.$route.params.locationId).then (response => {
            this.checkins = response;
        });
    },
}

</script>

<style scoped>

</style>