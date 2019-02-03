# Programmation concurrente en Java
## Définitions
### Processus  
Un processus est un programme (ensemble d'instructions) en cours d'exécution, un serveur exécute généralement plusieurs processus de façon quasi simultanée et qui sont totalement isolés les uns des autres, chaque processus possède ces propores ressources (mémoires, temps processeur,...).   
### Thread  
Un Thread est la plus petite unité d'excution (ensemble d'instructions) contenue dans un processus. Les threads d’un même processus partagent la même zone mémoire mais ils possèdent leur propre pile d'exécution. 

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Thread.png)  

### Ordonnanceur  

L’ordonnanceur/scheduler est un composant du noyau du système d'exploitation choisissant l'ordre d'exécution des processus/threads.



## Cycle de vie d’un Thread   

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Thread_lifecycle.png)  

### Création des threads en java   

#### Création par héritage de la classe Thread  
La classe Thread peut être utilisée pour créer et démarrer un nouveau thread, les étapes de création des instances sont:  

- Création d’une classe qui hérite de la classe Thread: ```` class MyThread extends Thread ````

- Redéfinition de la méthode run(): ````public void run() {...} ````

- Invocation de la méthode start() de l’instance créée:  ````  myThread.start() ```` 



#### Création par implémentation de l'interface Runnable  
Lorsqu’on utilise la méthode précédente pour créer des Threads on perd la flexibilité d'hériter d'une autre classe, pour contourner ce problème, au lieu d'étendre la classe Thread, on utilise l’implémentation de l'interface Runnable. les étapes de création d'une instance Thread:

- Création d’une classe implémentant l’interface Runnable: ````class MyRunnable implements Runnable````   

- Implémentation de la méthode run(): ````public void run() {...} ````  

- Instanciation d’un Objet Thread en passant l’instance Runnable au constructeur:  
```` Thread myThread = new Thread(new Sing());```` 

- Invocation de la méthode start() de l’instance créée: ````  myThread.start() ````  


### Lancement d’un thread   
On appelle la méthode start() une seule fois sur une instance de thread lorsque celle-ci est
à l'état NEW. L'appel de start () sur un thread dans un autre état déclenchera une exception IllegalThreadStateException.
  

### Suspendre l’exécution du Thread  
Un thread peut suspendre son exécution soit suite à l'appel d'une méthode explicite ou suite à l'expiration de la durée du temps processeur.  
- L’ordonnanceur déplace un thread de l'état RUNNING vers READY pour prendre en charge le traitement simultané des threads 
- Appel de la méthode yield() : La méthode statique yield() oblige le thread en cours d’exécution à suspendre son exécution et à abandonner son utilisation actuelle du processeur (passe à l’état READY aussi Il est possible que l’ordonnanceur peut aussi l'ignorer)
- Appel de la méthode sleep() : la méthode statique Thread.sleep() force le thread en cours d'exécution à abandonner temporairement son exécution pendant au moins le nombre de millisecondes (et de nanosecondes) spécifié et à passer à l'état TIMED_WAITING.
- Appel de la méthode join() : La méthode d’instance join() garantit que le thread appelant n’exécutera pas son code restant jusqu'à ce que le thread sur lequel il appelle join() se termine. La classe thread surcharge la méthode join() comme suit :  

````public final synchronized void join(long milli) throws InterruptedException````  

````public final synchronized void join(long millis, int nanos)````  

````throws InterruptedException ````  

````public final void join() throws InterruptedException ````  

- Appel des méthodes wait(), notify(), et notifyAll(): Un thread peut suspendre son exécution et attendre un objet en appelant wait(), jusqu’à ce qu’un autre thread appelle notify() ou notifyAll() sur le même objet. Les méthodes wait(), notify() et notifyAll() peuvent être appelées sur tous les objets Java, car ils sont définis dans la classe Object et non dans la classe Thread.  
Les méthodes wait (), notify () et notifyAll () doivent être appelées à partir d’une méthode ou blocs de code synchronized, sinon une exception IllegalMonitorStateException sera levée par la JVM.

### Terminer l'exécution d’un Thread  
Un thread termine son exécution lorsque sa méthode run () est terminée, il est non recommandé d'utiliser la méthode stop() pour terminer l’exécution d’un Thread. 

## Code thread-safe  
Un code est thread-safe s'il fonctionne correctement lors de l'exécution simultanée par plusieurs threads. La première étape pour écrire un code thread-safe est l’identification de données qui sont partagées entre les threads.  
Les zones de mémoire de la JVM peuvent être classées en deux groupes :   

- Géré par thread : la zone mémoire est allouée pour chaque thread créé, ces zones de données sont initialisées au démarrage du thread et détruites à la fin du thread (JVM Stack Area, Native Method stacks, PC Registers)

- Partagé avec tous les threads : la zone de mémoire est commune et accessible à tous les threads, initialisée au démarrage de la machine virtuelle Java et détruite à l'arrêt (Heap Area, Method Area)  

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/JVM_Data_Areas_.png)

- Heap Area : La zone de données heap est utilisée pour stocker des objets de classes et les tableaux.

- Method Area : Toutes les données de niveau classe seront stockées dans method area, y compris les variables statiques. Il existe une seule zone de méthode par machine virtuelle et il s'agit d'une ressource partagée.

- JVM Stack Area : Pour chaque thread, une pile d'exécution distincte sera créée. Pour chaque appel de méthode, une entrée sera faite dans la mémoire de pile appelée Stack Frame. Toutes les variables locales seront créées dans la mémoire de la pile.

- PC Registers : Chaque thread aura des registres PC distincts, afin de conserver l'adresse de l'instruction en cours d'exécution une fois l'instruction exécutée, le registre PC sera mis à jour avec l'instruction suivante.

- Native Method stacks : contient des informations sur la méthode native. Pour chaque thread, une pile de méthodes natives distincte sera créée.


### Verrouillage d’objets et moniteurs  
Chaque objet Java est associé à un moniteur, qui peut être verrouillé ou déverrouillé par un thread. À la fois, un seul thread peut verrouiller un moniteur (propriétaire du moniteur). Si un autre thread souhaite acquérir le moniteur de cet objet, il doit attendre qu'il soit libéré. Une fois acquis, un thread peut libérer le verrou sur le moniteur si :  
- Il a terminé son exécution.  

- Il doit attendre qu'une autre opération soit terminée.  

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Verrouillage_moniteurs.png)  


### Méthode synchronized  
Les méthodes qui modifient l'état des variables d'instance ou statiques doivent être définies en tant que méthodes synchronized. Cela empêche plusieurs threads de modifier les données partagées de manière à générer des valeurs incorrectes.  
Les méthodes Synchronized sont définies en préfixant la définition d'une méthode avec le mot clé synchronized (méthode statique ou d’instance). ```` synchronized public void myMethod() {....}````  
Lorsqu'un thread appelle une méthode synchronisée, il verrouille automatiquement le moniteur. Si la méthode est une méthode d’instance, le thread verrouille le moniteur associé à l’instance (référencé par this). Pour les méthodes statiques, le thread verrouille le moniteur associé à l'objet Class.

### Bloc synchronized  
Pour exécuter des instructions d’un bloc synchronized, un thread doit acquérir un verrou sur un moniteur de 'importe quel objet  

```` public void myMethod() {````  

````synchronized(anyObject) { .... ````  
```` } ````  

````} ```` 


### Objets immuables  
Les objets immuables ne peuvent pas donner lieu à des données incohérentes ou à un état incorrect car, une fois initialisées, elles ne sont pas modifiables. Les objets immuables tels qu'une instance de la classe String et toutes les classes wrapper (Boolean, Long, Integer, etc.) sont thread-safe.  

### Variables volatiles  
Dans un environnement multithread, chaque Thread peut copier des variables de la mémoire principale dans un cache de la CPU (pour des raisons de performances). Si le serveur contient plusieurs processeurs, chaque thread peut s'exécuter sur un processeur différent.  Il n'y a aucune garantie quand la JVM fait la synchronisation entre les caches et la mémoire principale ce qui peut engendrer l’incohérence de données.  

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/volatile.png)  

Les variables volatiles Java sont des variables qui sont toujours lues directement à partir de la mémoire principale. Lorsqu'une nouvelle valeur est affectée à une variable volatile, la valeur est toujours écrite immédiatement dans la mémoire principale. Cela garantit que la dernière valeur d'une variable volatile est toujours visible par les autres threads. 

L'écriture d'une valeur dans une variable volatile est une opération atomique. Cependant, une séquence read-update-write  effectuée sur une variable volatile n'est pas atomique et conduit toujours à des conditions de concurrence si elle est effectuée par plusieurs threads (exemple opérations sur les compteurs), si deux threads lisent et écrivent à la fois sur une variable partagée, utiliser le mot-clé volatile ne permet pas de résoudre le problème d’accès concurrent.

Si un seul thread lit et écrit la valeur d'une variable volatile et que d'autres threads ne lisent que la variable, alors les threads en lecture verront la dernière valeur écrite dans la variable volatile. Sans rendre la variable volatile, cela ne serait pas garanti.

### Problèmes dans un environnement multithread  

#### Deadlock  
Le Deadlock se produit lorsqu'un thread attend un verrou d'objet, acquis par un autre thread et que le second thread attend un verrou d'objet acquis par le premier thread.  

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Deadlock.png)

#### Starvation  
Starvation décrit une situation dans laquelle un thread détient un verrou pendant longtemps, de sorte que les autres threads sont bloqués :
- Les threads sont bloqués indéfiniment car un thread met longtemps à exécuter un code synchronized  

- Un thread ne reçoit pas de temps CPU pour l'exécution car il a une priorité basse par rapport aux autres threads qui ont une priorité plus élevée.  

#### Livelock  
Les threads dans un livelock ne sont pas bloqués, ils se répondent, mais ils ne peuvent pas aller jusqu'au bout. C'est comparable à deux personnes A et B qui se croisent dans un couloir. A se déplace à sa gauche pour laisser passer B, tandis que B se déplace à sa droite pour laisser passer A. Ils se bloquent, A se place à sa droite, tandis que B se place à sa gauche. Ils se bloquent encore.

## Le framework Executor
La classe Thread et l'interface Runnable sont fortement couplées à la notion de tâche (unité logique de travail), pour les programmes complexes il est nécessaire de faire une séparation entre la définition d’une tâche (logique métier) et la création et la gestion des threads (responsabilité Technique).    
Le Framework Executor permet de découpler la soumission de tâches de l'exécution. On peut créer des tâches à l'aide des interfaces Runnable et Callable, ces tâches sont soumises à l'exécuteur.  

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/Executor.png)  

Les classes et les interfaces principales dans le package java.util.concurrent  

![](https://github.com/AfifBouzidi/JAVA_CONCURRENCY/blob/master/java.util.concurrent.png)
