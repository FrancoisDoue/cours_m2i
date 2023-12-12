<script setup>
import { ref } from 'vue';

const props = defineProps({
    todo: {type: String, required: true },
    index: {type: Number, required: true }
})
const emit = defineEmits(['delete-item', 'edit-item'])
const emitEditItem = () => {
    toggleEdit.value = false;
    if(todoEdit === props.todo) return;
    emit('edit-item', todoEdit, props.index)
}
let todoEdit = ref(props.todo);
let toggleEdit = ref(false);
</script>

<template>
<div>
    <li class="d-flex flex-row">
        <div v-if="!toggleEdit" class="d-flex">
            <div>
                {{ props.todo }}
            </div>
            <div>
                <button @click="toggleEdit = true" class="btn btn-primary">Editer</button>
            </div>
            <div>
                <button @click="$emit('delete-item', props.index)" class="btn btn-danger mx-2">Supprimer</button>
            </div>
        </div>
        <div v-else class="d-flex">
            <div>
                <input type="text" v-model="todoEdit" >
            </div>
            <div>
                <button @click="emitEditItem" class="btn btn-success">Modifier</button>
            </div>
        </div>

    </li>
</div>
</template>

<style scoped>

</style>
