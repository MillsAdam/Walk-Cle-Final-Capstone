<template>
    <div>
        <ul>
            <li v-for="checkin in checkins" :key="checkin.id">
                {{ checkins.checkinId }}
            </li>
        </ul>
    </div>
</template>

<script>
import checkInService from '../services/checkInService.js';

export default {
    name: 'checkin-history-comp',
    data() {
        return {
            checkins: [],
        }
    },
    created() {
        checkInService.barCheckIn(this.$route.params.locationId).then (response => {
            this.checkins = response.data;
        });
    },
}

</script>

<style scoped>

</style>