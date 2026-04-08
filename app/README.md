#Les Bases de Jetpack Compose

Un projet d'apprentissage Android développé en Kotlin avec Jetpack Compose, 
couvrant les composables de disposition fondamentaux.

---

À propos

Adam Drabo

Étudiant en développement d'applications mobiles Android  
Collège Ahuntsic · Spécialisation Android avec Kotlin & Jetpack Compose

---

## Ce que j'ai appris!!!

### Jetpack Compose — L'approche déclarative

Jetpack Compose est le toolkit UI moderne d'Android. 
Contrairement à l'ancien système XML, tout est écrit en Kotlin pur de manière déclarative : 
on décrit ce qu'on veut afficher, et Compose met à jour l'interface automatiquement quand l'état change.

---

### Le Modifier

Le `Modifier` est l'outil central de stylisation en Compose. 
Il s'enchaîne comme un builder immuable — chaque méthode retourne un nouveau `Modifier` 
avec la transformation ajoutée.

```kotlin
Modifier
    .fillMaxWidth()
    .height(8.dp)
    .background(Color.DarkGray)
```

**Bonne pratique : toujours déclarer `modifier: Modifier = Modifier` comme paramètre de ses composables et l'appliquer sur le **composant racine uniquement**.

```kotlin
@Composable
fun MonComposable(modifier: Modifier = Modifier) {
    Column(modifier = modifier) { // sur la racine
        Text("enfant 1")
        Text("enfant 2")
    }
}
```

---

### Composables de base

#### `Column` — disposition verticale

Empile ses enfants les uns sous les autres.

```kotlin
@Composable
fun DemoColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bonjour Adam")
        Text("Bienvenue sur mon application")
    }
}
```

| Paramètre | Rôle |
|-----------|------|
| `verticalArrangement` | Espacement entre les enfants (ex: `spacedBy`, `SpaceBetween`) |
| `horizontalAlignment` | Alignement horizontal des enfants |

---

#### `Row` — disposition horizontale

Place ses enfants côte à côte.

```kotlin
@Composable
fun DemoRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(), // obligatoire pour SpaceBetween
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Campagne")
        Text("Champ")
    }
}
```

> `fillMaxWidth()` est obligatoire pour que `Arrangement.SpaceBetween` 
> soit visible — sans ça,
> la Row n'a pas de largeur sur laquelle s'étirer.

---

#### `Box` — superposition

Superpose ses enfants les uns sur les autres.

```kotlin
@Composable
fun DemoBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape), // découpe en cercle avant le contenu
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
```

> L'ordre du `Modifier` est important : `.clip()` doit venir **avant** tout padding intérieur, 
> et le padding externe doit être passé depuis l'**appelant** et non défini à l'intérieur du composable.

---

### Le composable principal

`LesBasesDeCompose` est le composable racine qui orchestre l'écran entier.

```kotlin
@Composable
fun LesBasesDeCompose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.systemBars) // évite la barre de statut
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DemoColumn()

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color.DarkGray)
        )

        DemoRow()

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color.DarkGray)
        )

        DemoBox(modifier = Modifier.padding(top = 16.dp))
    }
}
```

---

### Preview — prévisualisation sans émulateur

```kotlin
@Preview(showBackground = true)
@Composable
fun LesBasesDeComposePreview() {
    LesBasesDeCompose()
}
```

`@Preview` permet de voir le rendu directement dans Android Studio sans avoir à lancer un émulateur.

---

## Points clés retenus

- Le `modifier` paramètre s'applique toujours sur le **composant racine**, jamais sur un enfant
- Un `Spacer` coloré nécessite `.fillMaxWidth()` sinon il a une largeur de 0 il est invisible
- `contentAlignment` sur un `Box` positionne le contenu **à l'intérieur** du Box, pas le Box lui-même
- Pour centrer un composable dans l'écran, c'est le **parent** qui contrôle la position, pas le composable lui-même
- L'ordre des méthodes dans un `Modifier` change le comportement visuel (`.clip()` avant `.padding()` ≠ `.padding()` avant `.clip()`)


