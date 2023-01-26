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
    * Create profile receives a CreateProfileCommand. It alows to isolate the web layer from the application layer
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


* When a profile is created we should also create a user for security. Maybe, security user and profiles could come from the same 
table
* 