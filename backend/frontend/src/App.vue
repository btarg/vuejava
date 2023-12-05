<!-- App.vue -->
<template>
  <div id="app">
    <h1>My Custom Object Form</h1>
    <form @submit.prevent="submitForm">
      <label for="testString">Test String:</label>
      <input v-model="myCustomObject.testString" type="text" id="testString" />

      <label for="testInt">Test Integer:</label>
      <input v-model.number="myCustomObject.testInt" type="number" id="testInt" />

      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      myCustomObject: {
        testString: '',
        testInt: null,
      },
    };
  },
  methods: {
    submitForm() {
      // Send the MyCustomObject to the backend
      axios.post('/api/receiveObject', this.myCustomObject)
          .then(response => {
            console.log('Object submitted successfully:', response.data);
          })
          .catch(error => {
            console.error('Error submitting object:', error);
          });
    },
  },
};
</script>

<style scoped>
/* Add your custom styles here */
</style>
