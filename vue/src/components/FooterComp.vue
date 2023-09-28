<template>
  <div class="container">
    <nav id="footer">
      <ul>
        <li>
          <router-link v-bind:to="{ name: 'home' }">
            <img src="../assets/Footer-Images/home.png" id="home" />
          </router-link>
        </li>
        <li>
          <router-link v-bind:to="{name: 'google'}">
            <img src="../assets/Footer-Images/marker.png" id="marker" />
          </router-link>
        </li>
        <li>
          <img src="../assets/logo/small.png" id="logo" />
        </li>
        <li>
          <img src="../assets/logo/small.png" id="logo" />
        </li>
        <li>
          <a href="#" id="trophy-link">
            <img src="../assets/Footer-Images/trophy.png" id="trophy" />
          </a>
        </li>
        <li>
          <a id="menu-link" @click.prevent="toggleDropdown">
            <img src="../assets/Footer-Images/menu-burger.png" id="menu" />
            <ul v-if="isDropdownOpen" class="dropdown-menu">
              <a href="#" class="dropdown-option">Profile</a>
              <a href="#" class="dropdown-option">Settings</a>
              <router-link :to="{ name: 'logout' }" class="dropdown-option">
                <a href="#" class="dropdown-option">Logout</a>
              </router-link>
            </ul>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: "footer-comp",
  data() {
    return {
      isDropdownOpen: false,
    };
  },
  methods: {
    toggleDropdown() {
      this.isDropdownOpen = !this.isDropdownOpen;
    },
  },
};
</script>

<style scoped>
img {
  width: 24px;
  height: auto;
}

.container {
  width: 100%;
  background-color: #92b9c5;
  height: auto; /* Use auto to adjust to content */
  padding: 0;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "footer";
  /* justify-content: center;
  align-items: center; */
}

nav ul {
  list-style: none;
  margin: 0; /* Remove default margin */
  padding: 4px 0 0 0;
  display: flex;
  justify-content: space-between; /* Spread items evenly */
  /* align-items: center; */
  width: 100%; /* Adjust the width as needed */
}

#footer {
  grid-area: footer;
<<<<<<< HEAD
  margin: 10px 10%;
=======
}

#logo {
  margin-top: 8px;
  width: 30px;
  height: auto;
}

img {
  width: 24px;
  height: 24px;
>>>>>>> f522bb6f5f84681d37ffeadcae4f411ac7576770
}

.dropdown-menu {
  display: flex;
  flex-direction: column;
  list-style: none;
  padding: 0;
  margin: 0;
  position: absolute;
  background-color: rgba(146, 185, 197, 0.75);
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  top: auto;
  bottom: auto;
  left: 0;
  right: 0;
  margin-top: -100px;
}

.dropdown-option {
  padding: 0;
  cursor: pointer;
  transition: background-color 0.2s;
}

.dropdown-option:hover {
  background-color: #f0f0f0;
}
</style>