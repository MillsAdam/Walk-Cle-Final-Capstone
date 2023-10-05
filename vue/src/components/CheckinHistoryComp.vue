<template>
    <div>
        <ul>
            <li v-for="checkin in checkins" :key="checkin.checkinId">
                {{ checkin.locationName }} |
                {{ checkin.timestamp }}
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
        checkInService.checkInRecords().then (response => {
            this.checkins = response.data;
        });
    },
}

</script>

<style scoped>
ul {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center;
    padding: 0;
    margin-bottom: 100px;
}

li {
    list-style: none;
    margin-bottom: 10px;
}
</style>