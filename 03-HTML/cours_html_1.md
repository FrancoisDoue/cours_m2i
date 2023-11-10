#  Les bases du HTML

Le HTML, (HyperText Markup Language) est le langage de balisage utilisé pour créer et structurer le contenu d'une page web. Il s'agit d'une composante fondamentale du World Wide Web permettant au créateur de sites web de définir la structure et la présentation des informations affichées dans un navigateur.   
HTML fonctionne en utilisant un système de balise qui décrivent le type de contenu et sa mise en forme.

## Notions clés

1. **Balises et élements** : *(Tags & elements)* En HTML, le contenu est structuré à l'aide de balises. les balises sont des éléments entourés de chevrons angulaires `<>`. Elles sont utilisées pour définir différents types de contenus tels que les titres, paragraphes, images, liens etc..  
Si je souhaite inclure des chevrons dans mon texte qui ne soient pas considérés comme une ouverture de balise HTML, je peux utiliser le caractère d'échappement `&` avec les suffixes `lt` "lesser than" ou `gt` "greater than".

2. **Balises ouvrantes et fermantes** *(opening tags and closing tags)* La plupart des balises en HTML ont une balise ouvrante et une balise fermante pour délimiter le contenu qu'elles affichent. La balise fermante a un slash `/` qui se situe juste avant le nom de l'élément.
    ```html
    <p> Ceci est un paragraphe </p>
    ```
3. **Balises orphelines ou autofermantes** *(self-closing tags)* Il existe cepandant quelques exceptions, certaines balises n'ont pas besoin d'afficher du texte. On les nommes balises "orpheline"
    ```html
    <input /> 
    or
    <input>
    ```
4. **La hiérarchisation** *(Nesting)* On peut imbriquer des balises les unes dans les autres pour créer une structure hiérarchique.  
Les balises internes sont contenues dans les balises externes.
    ```html
    <u>
        <li>Objet 1</li>
        <li>Objet 2</li>
        <li>Un autre objet...</li>
    </u>
    ```

5. **Attributs** Une balise peut avoir des attributs qui fournissent des informations supplémentaires sur l'élément. Les attributs sont toujours spécifiés à l'intérieur de la balise ouvrante
    ```html
    <p title="informations complémentaires">
        paragraphe...
    </p>
    ```
6. **La structure de base** Une page HTML de base commence généralement par une déclaration de type de document: `<!DOCTYPE>` suivi d'une balise `<html>` qui elle même contient les balises `<head>` pour les métadonnées et `<body>` pour le contenu
    ```html
    <!DOCTYPE>
    <html lang="fr">
        <head>
            <!-- metadonnees . . . -->
        </head>
        <body>
            <!-- donnees . . . -->
        </body>
    </html>
    ```
    Le HTML fournit la structure fondamentale d'une page web, mais pour définir le style et le comportement, il est souvent utilisé avec des langages tels que le CSS (Cascading Style Sheets) pour la mise en page et le Javascript pour l'intéraction dynamique des utilisateurs.

## Balises de base

```html
    <h1>Balise de titrage</h1>
    <h2>titre 2</h2>
    <h3>titre 3</h3>
    <h4>titre 4</h4>
    <h5>titre 5</h5>
    <h6>titre 6</h6>


    <p>Paraphraphe <br>Saut de ligne!</p>
    <!-- séparateur hr  -->
    <hr/>
```
## Balises de mise en forme

<b>Mise en gras</b>  
<u>Souligner</u>  
<i>Italique</i>

On évitera utiliser ces trois balises, on préfèrera appliquer le style en CSS

```html
<strong> Indique l'importance d'une partie de texte (Le navigateur l'appliquera en gras) </strong>
<em>(emphasis) met l'emphase sur une partie du texte (le navigateur l'appliquera en italique)</em>
```
<strong>Strong</strong> <br>
<em>Emphasis</em>

<code>
    On peut entourer du code avec la balise
</code>
<pre>
    <h3>balise PRE</h3>
    ici, comme la balise code, la balise pre affiche du code
                    mais elle permet aussi l'indentation
</pre>

## Liens et ancres

La balise `<a>` en html est utilisée pour créer des hyperliens, communément appelés liens hypertextes, dans une page web. Les liens permettent aux utilisateurs de naviguer vers d'autres page web, télécharger des fichier, d'envoyer des mails ou simplement de naviguer à l'intérieur d'une même page.
### Syntaxe de base : 
```html
<a href="https://www.exemple.com" >Cliquer ici pour visiter exemple.com</a>
```
### Attributs de la balise `<a>`
1. `href` Contiendra l'url relatif ou absolu
2. `target`: cet attribut détermine comment la page liée sera affichée. les valeurs courantes sont:  
    -> `_blank` : ouvrir un lien dans un nouvel onglet ou une nouvelle fenêtre
    -> `_self` ouvre un lien dans la même fenêtre ou onglet. (par défaut, **mais mieux vaut spécifier**)

### Les liens internes
La balise a peut également être utilisé pour créer des liens internes à une même page, généralement pour permettre aux utilisateurs de sauter au différentes parties de la page.

On reliera donc une balise `<a>` à un identifiant
```html
    <a href="section2"> Aller à la section 2 </a>
    .
    .
    .
    .
    .
    <h2 id="section2">Section 2</h2>
```

### Autres utilisations:

1. L'attribut `download` indique au navigateur que le lien doit être téléchargé au lieu d'être affiché
```html
<a href="./telecharger_pdf.pdf">Télécharger le fichier</a>
```
2. Pour envoyer un courriel on spécifie le chemin `mailto`
```html
<a href="mailto:contact@mail.com">Envoyer un mail</a>
```

# Les tableaux et boutons en HTML

## Les tableaux

```html
<table>
    <thead>
        <!-- tr -> row -->
        <tr>
            <!-- th -> col header -->
            <th>header 1</th>
            <th>header 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <!-- td -> col data -->
            <td>data 1 - 1</td>
            <td>data 2 - 1</td>
        </tr>
        <tr>
            <td>data 1 - 2</td>
            <td>data 2 - 2</td>        
        </tr>  
    </tbody>
</table>
```
Pour le référencement et un code plus lisible, je précise grace aux balises `<thead>`, `<tbody>` et `<tfoot>` l'organisation du tableau

On peut ajouter un titre à son tableau en utilisant `<caption>`
Au niveau des attributs, on peut rajouter des attributs de style à notre tableau, mais on évitera de le faire si on utilise le CSS.  
`border= taille_en_px` taille en px des bordures  
`width= taille_en_px` longueur en pixel des tableau  
`height= taille_en_px` hauteur en pixel des tableau  
`align= left right center` alignement vertical des données  

