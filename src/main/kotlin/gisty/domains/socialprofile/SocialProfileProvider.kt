package gisty.domains.socialprofile

enum class SocialProfileProvider {
    GOOGLE {
        override fun typeName(): String = "google"
    };

    abstract fun typeName(): String

    companion object {
        fun init(providerName: String): SocialProfileProvider{
            return when(providerName){
                "google" -> GOOGLE
                else -> throw IllegalArgumentException()
            }
        }
    }
}
