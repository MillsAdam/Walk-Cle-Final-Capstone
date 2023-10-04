import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000/rewards'
})
export default{
    barCheckIn(locationId) {
        return http.get(`/barcheckin/${locationId}`)
    }
}