import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
})
export default{
    getAllLocations() {
        return http.get('/locations')
    },
    getAllLocationTypes() {
        return http.get('/locationtypes')
    },
    getLocation(locationId) {
        return http.get(`/locations/id/${locationId}`)
    }

}