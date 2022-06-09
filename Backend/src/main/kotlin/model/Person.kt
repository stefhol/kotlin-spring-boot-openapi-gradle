package default.model


import javax.persistence.*

@Entity
class Person() :AbstractJpaPersistable<Long>(){
    lateinit var name: String
    @ManyToMany(cascade = [(CascadeType.ALL)],  fetch = FetchType.EAGER)
    var team: MutableList<Team> = mutableListOf()
}

@Entity
class Team:AbstractJpaPersistable<Long>(){
    lateinit var name: String
    @ManyToMany(mappedBy="team")
    var users: MutableList<Person> = mutableListOf()
}
