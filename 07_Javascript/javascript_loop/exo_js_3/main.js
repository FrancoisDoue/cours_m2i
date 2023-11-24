// let r = +prompt('Entrez le rayon du cône : ')
// let h = +prompt('Entrez la hauteur du cône : ')

// let diameter = Math.PI * r**2;
// let volume = diameter/3*h;

// alert(`Volume d'un cône de rayon ${r} et de hauteur ${h} :\n ${Math.floor(volume*100)/100}`)
// alert(`Volume du cône : \n ${Math.floor(((Math.PI*Number(prompt('Rayon du cône :'))**2)/3*Number(prompt('Hauteur du cône : ')))*100)/100}`)

window.onload = (r, h) => alert(`Volume d'un cône de rayon ${r = +prompt('Entrez le rayon du cône : ')} et de hauteur ${h = +prompt('Entrez la hauteur du cône : ')} :\n ${(Math.PI*r**2/3*h).toFixed(2)}`);