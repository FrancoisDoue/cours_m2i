export default class Animal {
  static count = 0;

  constructor(name, breed, age) {
    this.id = ++Animal.count;
    this.name = name;
    this.breed = breed; 
    this.age = age;
  }
}