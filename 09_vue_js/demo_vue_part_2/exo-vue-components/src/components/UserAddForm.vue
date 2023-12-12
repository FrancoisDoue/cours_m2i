<script setup>
import { ref } from 'vue';
import {v4 as uuid4} from 'uuid';

  let userName = ref('');
  let userMail = ref('');
  let msgAlert = ref('');
  let isAlert = ref('false');
  let classesAlert = '';
  let alertTimeout;

  const emit = defineEmits(['add-user']);

  const userFormControl = () => {
    isAlert.value = true;
    if (userName.value && userMail.value) {
      msgAlert.value = 'User sucessfully added';
      classesAlert = 'alert alert-success py-3 my-2';
      emit('add-user', {id: uuid4(), username: userName.value, usermail: userMail.value});
      userName.value = '';
      userMail.value = '';
    }else{
      msgAlert.value = 'Please fill out all required fields';
      classesAlert = 'alert alert-danger py-3 my-2';
    }
    alertTimeout = setTimeout( () => {
        resetUserFormControl();
      }, 2000)
  }
  const resetUserFormControl = () => {
    isAlert.value = false;
    msgAlert.value = '';
    classesAlert = '';
    if (alertTimeout) clearTimeout(alertTimeout);
  }

</script>

<template>
  <form class="col-4 my-4 text-center">
    <h2 class="">Users</h2>
    <div class="d-flex flex-column mt-4">
      <label for="form-username">Name</label>
      <input type="text" id="form-username" v-model="userName" @focus="resetUserFormControl" class="form-control">
    </div>
    <div class="d-flex flex-column mt-2">
      <label for="form-useremail">Email</label>
      <input type="email" id="form-useremail" v-model="userMail" @focus="resetUserFormControl" class="form-control">
    </div>
    <div class="d-flex justify-content-center mt-4">
      <button type="submit" @click.prevent.click="userFormControl" class="btn btn-primary">
        Add user
      </button>
    </div>
    <div v-if="isAlert" :class="classesAlert">
      {{ msgAlert }}
    </div>

  </form>
</template>

<style scoped>

</style>
