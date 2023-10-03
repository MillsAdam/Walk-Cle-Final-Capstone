<template>
<div class="container">
    <h1 id="title">CLE-WARDS</h1>
    <div class="images">
        <div class="trophy-all">
            <img src="../assets/trophies/defender.jpg" id="defender" />
        </div>
        <div class="trophy-types">
            <img src="../assets/trophies/bar.jpg" id="bar" />
            <img src="../assets/trophies/sport.jpg" id="sport" />
            <img src="../assets/trophies/tree.jpg" id="tree" />
        </div>
    </div>
</div>
</template>

<script>

export default {
name: 'rewards-comp',
}
</script>


<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    text-align: center;
}

#title {
    font-size: 24px;
    margin-top: 20px;
}

.images {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
}

.trophy-all img, .trophy-types img {
    max-width: 250px;
    height: auto;
    margin: 10px;
}

.trophy-types {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    margin-top: 20px;
}
</style>