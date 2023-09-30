<template>
  <div>
    <button id="btn" @click="addParks">Add Markers</button><button id="btn" @click="addBars">Add Markers</button><button id="btn" @click="addSports">Add Markers</button><button id="btn" @click="addPOI">Add Markers</button>
    <div id="map"></div>
  </div>
</template>

<script>
import mapboxgl from "mapbox-gl";

mapboxgl.accessToke = process.env.VUE_APP_MAPBOX_KEY;
export default {
  components: {
    
  },

  data() {
    return {
      map: null,
      markers: [],
      popupTexts: [
        "This is the first marker's custom text.",
        "This is the second marker's custom text.",
        // Add more custom texts here, one for each marker
      ],
      parkText: [
        "1",
        '2',
      ],

    };
  },
  methods: {
    initMap() {
      // Create map object
      this.map = new mapboxgl.Map({
        container: "map",
        style: "mapbox://styles/walkcle216/cln4qqvn306wt01qi05mi9h14",
        center: [-81.681290, 41.505493],
        zoom: 15,
      });
    },
    addParks() {
      const coordinates = [
        [-81.7138946, 41.4991564],
        [-81.7013211, 41.4966056],
        // Add more coordinates here
      ];

      // Debugging: Log the coordinates array
      console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();

      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
        const popupText = this.parkText[index];

        // Create a popup with custom content
        const popupContent = `
          <div>
            <p>${popupText}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200">
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.markers.push(marker);
      });
    },

  removeMarkersAndPopups() {
  this.markers.forEach((marker) => {
    marker.remove();
  });
  this.markers = [];
    },

addBars() {
  const coordinates = [
    [-81.7037735,41.4986853],
    [-81.6900132,41.4991465],
    [-81.6991611,41.5005667],
    [-81.698024,41.492705],
    [-81.7045326,41.4844029]
     // Replace with your desired coordinates
    // Add more coordinates here
  ];

  // Debugging: Log the coordinates array
   // Debugging: Log the coordinates array
      console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();

      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
        const popupText = this.popupTexts[index];

        // Create a popup with custom content
        const popupContent = `
          <div>
            <p>${popupText}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200">
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.markers.push(marker);
      });
    },
    addSports() {
  const coordinates = [
    [-81.6852949,41.4958921],
    [-81.6995481,41.5060535],
    [-81.6880574,41.4965474],
     // Replace with your desired coordinates
    // Add more coordinates here
  ];

  console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();

      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
        const popupText = this.popupTexts[index];

        // Create a popup with custom content
          const popupContent = `
          <div>
            <p>${popupText}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200"/>
    </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.markers.push(marker);
      });
    },
    addPOI() {
  const coordinates = [
    [-81.6852949,41.4958921],
    [-81.6995481,41.5060535],
    [-81.6880574,41.4965474],
     [-81.7037735,41.4986853],
    [-81.6900132,41.4991465],
    [-81.6991611,41.5005667],
    [-81.698024,41.492705],
    [-81.7045326,41.4844029],
    [-81.7138946,41.4991564],
    [-81.7013211,41.4966056],

     // Replace with your desired coordinates
    // Add more coordinates here
  ];

 console.log("Coordinates:", coordinates);

      // Remove existing markers and popups
      this.removeMarkersAndPopups();

      // Add markers for each coordinate
      coordinates.forEach((coord, index) => {
        const marker = new mapboxgl.Marker({ color: "blue" })
          .setLngLat(coord)
          .addTo(this.map);

        // Get the custom text for this marker
        const popupText = this.popupTexts[index];

        // Create a popup with custom content
        const popupContent = `
          <div>
            <p>${popupText}</p>
            <img src="https://example.com/your-image-url.jpg" alt="Image" width="200">
          </div>
        `;

        const popup = new mapboxgl.Popup({ offset: 25 })
          .setHTML(popupContent);

        // Attach the popup to the marker
        marker.setPopup(popup);

        this.markers.push(marker);
      });
    },
    removeMarkers() {
      // Remove existing markers from the map and clear the markers array
      this.markers.forEach((marker) => marker.remove());
      this.markers = [];
    },
  },
  mounted() {
    this.initMap();
  },
};
</script>

<style scoped>
#map {
    height: 90vh;
    width: 100vw;
}
.btn {
  float: inline-end;
}
</style>
