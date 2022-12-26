# Projet Hex - Java <img src="https://media.giphy.com/media/WFZvB7VIXBgiz3oDXE/giphy.gif" width="40">
### Morgane BRETON 205, Vanessa PHAM 206, Alexia BENCE 206 et Chaimae EL MATTARI 206 

---

<article style="text-align: justify">
    Dans ce projet où il fallait réaliser un jeu de Hex, plusieurs problèmes ont été vus (et n'ont pas eu le temps d'être résolus). <br /><br />
    Nous avons représentés le plateau de jeu par un tableau à double dimension. <br />
    Afin de savoir si une partie est finie ou non, nous devons chercher s'il existe un chemin entre le haut et le bas de cette matrice, ou entre la gauche et la droite. <br/>
    Pour gérer cette fin de partie, avec la structure utilisée, nous n'avons pas trouvé d'autres solutions
    que de stocker les cases visitées dans un tableau, puis d'effectuer des récursions sur les cases adjacentes (dans les 8 directions autour de la case initiale).
    Cette méthode est très couteuse en complexité.
    L'idéal aurait été d'utiliser une autre structure de données pour représenter le plateau, en occurrence un disjoint-set.<br /><br />
    Au niveau de l'IHM, si le premier joueur gagne, le deuxième joueur pourra jouer encore un coup avant l'arrêt de la partie et la victoire du joueur 1
    (la vérification de fin de partie se fait à la fin d'un tour, après donc les coups des 2 joueurs). <br/>
    Les joueurs ne peuvent rentrer qu'un nom d'utilisateur à un seul mot.
</article>

---

<h3>Diagramme d'architecture</h3>
<img src="">DIAG IMG

---

<h3>Tests unitaires</h3>
<ul>
    <li>
    PionTest, teste l'attribution des valeurs de l'enum Pion.
    </li>
    <li>
    PlateauTest, teste les méthodes pour savoir la taille du plateau, pour jouer une case, ou si une case est vide.
    </li>
    <li>
    CheminTest, prends un plateau de jeu déjà rempli, vérifie les méthodes aCheminHB() (de haut en bas) et aCheminGD() (de gauche à droite).
    </li>
    <li>
    AleatoireTest, teste si le coup joué au hasard est une case à un emplacement valide.
    </li>
</ul>

---
<h3> Changements </h3>
<p>La règle de début de partie, où le deuxième joueur peut prendre le coup joué par le premier joueur, n'a pas été adaptée.
<br/>
Si le joueur joue contre une machine, celle-ci jouera une case aléatoirement.
Une autre approche intéressante aurait été d'utiliser la méthode de Monté-Carlo, c'est-à-dire de simuler des milliers de parties de Hex
et d'utiliser des algorithmes probabilistes afin de déterminer le meilleur coup à jouer selon chaque situation.
</p>

---
<h3>Bilan</h3>
<p>
Ce projet était très formateur, il nous a surtout aidé pour apprendre et maitriser les principes SOLID.
L'utilisation d'un Disjoint-set est sans doute la notion la plus intéressante à approfondir, bien qu'il serait idéal d'implémenter
toutes les fonctions du projet non finies abordées dans la première partie de ce rapport.
</p>