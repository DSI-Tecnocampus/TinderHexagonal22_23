# Tinder in an Hexagonal arquitecture

Note that we have 4 top packages
* Common: with common classes (now empty)
* Configuration: security and webClient configurations
* Likes: likes use cases
* Profiles: profiles use cases

We decided to separate likes and profiles. Maybe, it's a bit unnatural separation since the two concepts are really close in the
domain. 

## Profiles
The domain Profile class 

* Input ports:
  * Profile listings
    * Decided to add all different kind of profiles listing in a single file/interface ListProfiles
    * Profile listings produce a projection of profiles called ProfileListing. It's implemented as a record
  * Profile creation
    * The port/interface has one single method 
    * Create profile receives a CreateProfileCommand. It allows to isolate the web layer from the application layer
    * CreateProfileCommand has all the validation annotations
    * See that the port/interface has the annotations @Validation, at class level, and @Valid, at method's attribute level. 
      in this way the validation is performed within the application service implementing the port/interface 
* Output ports:
  * Mimicking the previous structure we have two different files, one for the listings and another for the profile creation
* Services:
  * As before we have two services that implement the input ports. One for listings and the other for profile creation
  * Note that both classes are private to the package. In this way, the adapters cannot use (import) they directly. They have to 
    use (import) the ports/interfaces
  * Services are coupled to the output ports/interfaces, not their implementation (output adapters)
* Adapters:
  * Input adapters
    * Note that input adapters (RestControllers in our case) just use the application services through the input ports. In the java code 
      they import the ports/interfaces instead of their implementations (the service classes). Anyway, because service classes are
      private, adapters can only be coupled with the ports/interfaces
    * See that the listing adapter uses the same application pots in two different rest entries (one using the principal (me) and the other
    getting the email from the path)
  * Output adapters
    * They need to implement the ports/interfaces declared by the application layer 
    * Adapter classe are private so that the application services can't couple (import) directly to them but only using (importing) 
    the ports/interfaces
    * Note that all the JPA details (ProfileRepository: spring jpa, ProfileEntity with all its annotations) are unknown by the application layer
    * The FetchProfileListingAdapter's methods return ProfileListings that belong to the application input ports. This is a **shortcut**
    * ProfileEntity:  it's used for JPA/hibernate machinery to create the table. 
    * StoreProfileAdapter: it receives a CreateProfileCommand, converts it to a ProfileEnity. Note that this goes from input to output without
    going thogh any domain object. This happens because the domain has no logic in the process of profile creation.


* For future versions: When a profile is created we should also create a user for security. Maybe, security user and profiles could come from the same 
table

## Likes
I decided to separate likes and profiles, like thet were different contexts (in the sense of DDD). 
I tried to make Likes dependent of Profiles and avoid any reference from Profiles to Likes. However, there the domain profile has a list of
likes. I could avoid that by moving the logics of creating likes from Profiles to the use case AddLikedProfilesService

* Input ports
  * Like listings (ListProfileLikes): 
    * There are two methods one that lists the likes of a profile (profile as origin) and the
    other that lists the likes with the profile as target, that is, profiles that liked me. 
    * Both methods produce a very simmilar object: a profile and a list of likes. However, I decide to use different DTO 
    that have different semantics. One for outgoing likes (ProfileLikes) and another for incoming likes (ReceivedLikes)
  * Create new likes (AddLikedProfiles)
    * Only one method
    * It receives a command with all the information the use case needs.
  * Note that there are no input ports that return domain Likes (but there are output ports that return domain Likes)
* Output ports 
  * Store likes
  * Load kiles: two interfaces that return domain Like
  * List profiles: ports intended to list profiles to the user. They list a projection of likes without Profiles object, just their email
* Services
  * There is one service/use case to create new likes
  * The other (input) ports are implemented directly by a persistence adapter (ListProfileLikeAdapter)
* Adapters
  * Input adapters
    * We have two REST adapters. One for listing and another one for creating new likes
    * Note that the ports to load domain Likes are not used by
  * Output adapters
    * ListProfileLikeAdapter is an output adapter and a service at the same time. It implements the listing like input ports (acting like a service)
    and aldo implements the output ports (for listing) acting as a persistence adapter. Note that both input and output ports have the
    same methods declared. 
    * The other adapters are "normal"
    * All the mappings are done in the output adapters layer
    
## Quotes
We will use a huge shortcut since this part of the application only needs to get some quotes from another REST API with no logic 

Make sure you have running on your machine the **quoter** application (running in the default localhost port, 80). Get the application from
  https://github.com/LabInternetPub/quoters and add *server.port=80* to the application.properties file.
  * Input ports: quotes "module" has only input ports where we define the ports (what the application offers) and the DTOs (the information structure) being used for the quotes.
  Note that the application *layer* has not other ports or services
  * Input adapters: it's the rest controller that uses the input ports
  * Output adapter: the adapters that, using a webClient, calls the **quoters** REST application
  * Note that the configuration of the webClient is situated in the "general" configuration package. We could have decided to have in this "module" 
  another *configuration* package with the "local" configurations that are only used in this "module".