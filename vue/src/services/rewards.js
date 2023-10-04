import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000/rewards'
})
export default{
    checkTrophyStatus() {
        this.checkDefenderTrophyStatus();
        this.checkBarTrophyStatus();
        this.checkParkTrophyStatus();
        this.checkStadiumTrophyStatus();
    },
    checkDefenderTrophyStatus() {
        http.get('http://localhost:9000/rewards/allPlacesVisited')
            .then(response => {
                this.$set(this.trophyStatus, 'defender', response.data);
            })
            .catch(error => {
                console.error(error);
            });
    },
    checkBarTrophyStatus() {
        http.get('http://localhost:9000/rewards/allBarsVisited')
            .then(response => {
                this.$set(this.trophyStatus, 'bar', response.data);
            })
            .catch(error => {
                console.error(error);
            });
    },
    checkParkTrophyStatus() {
        http.get('http://localhost:9000/rewards/allParksVisited')
            .then(response => {
                this.$set(this.trophyStatus, 'sport', response.data);
            })
            .catch(error => {
                console.error(error);
            });
    },
    checkStadiumTrophyStatus() {
        http.get('http://localhost:9000/rewards/allStadiumsVisited')
            .then(response => {
                this.$set(this.trophyStatus, 'tree', response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }
}