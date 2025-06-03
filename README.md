# MyRestApp

<p style="text-align: center;">Filippo Mattioli - 5AINF</p>

---

## Scopo del Progetto

**MyRestApp** è un'applicazione Android sviluppata in Kotlin che offre agli utenti un accesso, previa autenticazione, a servizi interni ed esterni, basati sulla ricerca di contenuti musicali.

Nello specifico, l'applicazione permette di:

1.  **Cercare canzoni**: Trovare informazioni e dettagli su brani musicali, visualizzandoli in un elenco.
2.  **Accedere allo streaming**: Aprire la piattaforma di streaming musicale esterna direttamente nel browser del dispositivo.
3.  **Gestire un archivio personale**: Una sezione dedicata per future implementazioni relative alle canzoni salvate o preferite.

---

## Struttura del Progetto

Il progetto è composto dalle seguenti Activity e componenti principali, che gestiscono le diverse funzionalità:

### 1. `LoginActivity.kt`

È la prima schermata che l'utente visualizza. Gestisce la logica di login.

La validazione delle credenziali avviene direttamente all'interno del `setOnClickListener` del bottone di accesso. Se l'username inserito è `"abbonato"` e la password è `"password"`, l'applicazione concede l'accesso e reindirizza alla `MenuActivity`. In caso contrario, mostra un messaggio di errore e resetta i campi di input.

### 2. `MenuActivity.kt`

Questa è la schermata principale a cui si accede dopo l'autenticazione. Offre tre bottoni per navigare verso le diverse funzionalità dell'app:

* **"Cerca Canzoni"**: Avvia la `SearchActivity`.
* **"Vai a Streaming"**: Avvia la `WebViewActivity`.
* **"Archivio Personale"**: Avvia la `LibraryActivity`.

### 3. `SearchActivity.kt`

Questa Activity è dedicata alla ricerca di canzoni. L'utente inserisce un termine di ricerca in un `EditText`, e all'azione "Invio" sulla tastiera, la funzione `fetchSongs()` viene invocata.

* **API di iTunes**: Utilizza `OkHttp` per inviare richieste all'URL `https://itunes.apple.com/search?term={query}&media=music`.
* **Parsing JSON**: La risposta JSON dell'API viene analizzata per estrarre `trackName` e `artistName`.
* **Visualizzazione Risultati**: I brani trovati vengono visualizzati in una `ListView` dinamica.
* **Gestione Errori**: Vengono mostrati `Toast` per errori di rete o di parsing.

### 4. `WebViewActivity.kt`

Questa Activity gestisce l'opzione "Vai a Streaming". A differenza di un `WebView` tradizionale, questa Activity apre direttamente un URL nel browser predefinito del dispositivo (attualmente `https://music.apple.com/it/`). Dopo aver lanciato il browser, l'Activity si chiude automaticamente per una migliore esperienza utente.

### 5. `LibraryActivity.kt`

Questa Activity rappresenta la sezione dell'archivio personale. Attualmente è una schermata placeholder (`activity_fifth`) pronta per future implementazioni. Qui potranno essere gestite le canzoni salvate dall'utente, le playlist o altre collezioni personali.

---

## Credenziali di Accesso

Per testare l'applicazione, puoi utilizzare le seguenti credenziali predefinite:

* **Username**: `abbonato`
* **Password**: `password`

---

## API Coinvolte

La funzionalità di ricerca canzoni fa uso dell'**API di iTunes**, che non richiede una chiave API specifica per le ricerche pubbliche.

---

## Funzionalità Future

Il progetto è progettato per essere espandibile. Alcune delle funzionalità pianificate includono:

* **Sviluppo completo dell'Archivio Personale**: Implementazione di funzionalità per la creazione, lettura, aggiornamento, eliminazione di canzoni salvate o playlist.
* **Integrazioni API avanzate**: Esplorare ulteriori interazioni con API esterne per arricchire l'esperienza musicale.
* **Miglioramenti interfaccia grafica**: Affinamenti estetici e funzionali per migliorare l'interfaccia utente.

---
