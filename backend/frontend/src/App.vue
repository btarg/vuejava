<template>
  <div id="app">
    <h1>Vue.js + Vite + Javalin + Gradle</h1>
    <input v-model="argument" placeholder="Enter argument" />
    <button @click="invokeJavaFunction">Invoke Java Function</button>
  </div>
</template>


<script>
// Import the necessary libraries
import axios from 'axios';

export default {
  data() {
    return {
      argument: 'YourArgumentValue' // Set a default value or bind to a data property in your component
    };
  },
  methods: {
    invokeJavaFunction() {
      axios.post('/api/invokeJavaFunction', { argument: this.argument })
          .then(response => {
            alert('Success: ' + response.data);
          })
          .catch(error => {
            alert('Error invoking Java function: ' +  error);
          });
    }
  }
};

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}
</style>
