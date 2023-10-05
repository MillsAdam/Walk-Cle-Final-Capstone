<template>
    <div>
        <ul>
            <li v-for="checkin in checkins" :key="checkin.checkinId">
                {{ checkin.locationName }} |
                {{ formatTimestamp(checkin.timestamp) }}
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
    methods: {
        formatTimestamp(timestamp) {
            // Create a JavaScript Date object from the timestamp
            const date = new Date(timestamp);
            
            // Format the date as per your preference (e.g., "YYYY-MM-DD HH:MM:SS")
            const formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`;
            
            return formattedDate;
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