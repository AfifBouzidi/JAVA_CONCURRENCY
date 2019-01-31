# Programmation concurrente en Java
## Définitions
### Processus  
Un processus est un programme (ensemble d'instructions) en cours d'exécution, Un serveur exécute généralement plusieurs processus de façon quasi simultanée et qui sont totalement isolés les uns des autres, chaque processus possède ces propores ressources (mémoires, temps processeur,...).   
### Thread  
Un Thread est la plus petite unité d'excution (ensemble d'instructions) contenue dans un processus. Les threads d’un même processus partagent la même zone mémoire mais ils possèdent leur propre pile d'exécution. 

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Thread.png)  


## Création des threads en java   

### Création par héritage de la classe Thread  
La classe Thread peut être utilisée pour créer et démarrer un nouveau thread, les étapes de création des instances sont:  

- Création d’une classe qui hérite de la classe Thread  ```` class MyThread extends Thread ````

- Redéfinition de la méthode run()  ````public void run() {...} ````

- Invocation de la méthode start() de l’instance créée  ````  myThread.start() ```` 



### Création par implémentation de l'interface Runnable  
Lorsqu’on utilise la méthode précédente pour créer des Threads on perd la flexibilité d'hériter d'une autre classe, pour contourner ce problème, au lieu d'étendre la classe Thread, on utilise l’implémentation de l'interface Runnable. les étapes de création d'une instance Thread:

- Création d’une classe héritant de l’interface Runnable   

- Implémentation de la méthode run()  

- Instanciation d’un Objet Thread en passant l’instance Runnable au constructeur  

- Invocation de la méthode start() de l’instance créée  




## Cycle de vie d’un Thread   

## Code thread-safe  


