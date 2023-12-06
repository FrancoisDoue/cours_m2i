<script setup>
import { computed, reactive, ref } from 'vue';

// let person = reactive({firstName: 'Jean', lastName: 'Bernard', birthday: new Date(1980, 5, 19)})

// const modifyBirthday = () => {
//   person.birthday = new Date((Math.random() * (2023 - 1920) + 1920), 5, 19);
// }

// let getAge = computed(() => new Date().getFullYear() - person.birthday.getFullYear());
  let isSelected = ref(false);
  let hasError = ref(false);
  let error = ref(null);
  let classes = computed(() => {
    return {'selected': isSelected.value, 'text-error': hasError.value && error.value}
  })
</script>

<template>
  <!-- <div>
    <p>{{ getAge }}</p>
    <button v-on:click="modifyBirthday">Modify birthday</button>
  </div> -->
  <p :class="classes">Yo</p>

  <button @click="isSelected = !isSelected"> Bouton 1 </button>
  <button @click="hasError = !hasError"> Bouton 2 </button>
  <button @click="error = hasError ? 'error text': null"> Bouton 3 </button>

</template>

<style scoped>
  .selected{
    border: 1px solid red;
  }
  .text-error{
    color: red;
  }
</style>
