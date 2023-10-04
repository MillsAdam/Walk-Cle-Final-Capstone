import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000/rewards'
})
export default{
    barCheckIn(locationId) {
        return http.post(`/barcheckin/${locationId}`)
    },

    parkCheckIn(locationId) {
        return http.post(`/parkcheckin/${locationId}`)
    },

    stadiumCheckIn(locationId) {
        return http.post(`/stadiumcheckin/${locationId}`)
    }
}