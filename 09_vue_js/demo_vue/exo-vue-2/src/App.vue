<script setup>
import { computed, reactive, ref } from 'vue';

// let person = reactive({firstName: 'Jean', lastName: 'Bernard', birthday: new Date(1980, 5, 19)})

// const modifyBirthday = () => {
//   person.birthday = new Date((Math.random() * (2023 - 1920) + 1920), 5, 19);
// }

// let getAge = computed(() => new Date().getFullYear() - person.birthday.getFullYear());
  // let isSelected = ref(false);
  // let hasError = ref(false);
  // let error = ref(null);
  // let classes = computed(() => {
  //   return {'selected': isSelected.value, 'text-error': hasError.value && error.value}
  // })
  let awesome = ref(true);
  let age = ref(0);
  let prenoms = ref(['prénom1', 'prénom2', 'prénom3'])
  let produits = ref([{id:1, name: 'Téléphone'}, {id:20, name: 'Souris'}, {id:62, name: 'Clavier'}])
</script>

<template>
  <!-- <div>
    <p>{{ getAge }}</p>
    <button v-on:click="modifyBirthday">Modify birthday</button>
  </div> -->
  <!-- <p :class="classes">Yo</p>

  <button @click="isSelected = !isSelected"> Bouton 1 </button>
  <button @click="hasError = !hasError"> Bouton 2 </button>
  <button @click="error = hasError ? 'error text': null"> Bouton 3 </button> -->
  <div>
    <h1 v-if="awesome">Bienvenue sur ce super site.</h1>
    <h1 v-else>Peut-être pas si super que ça, en fait</h1>
    <button @click="awesome = !awesome">Change title</button>
  </div>
  <hr>
  <form @submit.prevent>

    <input :input="age" @change="(e) => age = e.target.value" type="number" value="17">
    <button type="submit">Send</button>
  </form>
  <div>
    <p v-if="age < 18" class="text-error">Accès interdit</p>
    <p v-else>Accès autorisé</p>
  </div>
  <hr>
  <div>
    <ul v-for="(prenom, _index) in prenoms">
      <li>{{ prenom }}</li>
    </ul>
  </div>
  <hr>
  <div>
    <ul v-for="produit in produits" :key="produit.id">
      <li><span>{{ produit.id }}</span>  {{ produit.name }}</li>
    </ul>
  </div>


</template>

<style scoped>
  .selected{
    border: 1px solid red;
  }
  .text-error{
    color: red;
  }
</style>
