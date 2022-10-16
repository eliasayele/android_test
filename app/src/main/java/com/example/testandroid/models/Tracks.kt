package com.example.testandroid.models

import com.example.testandroid.R

/** dummy data from local, get from figma */

data class Tracks(val name: String,val image: Int,val description: String,val value:Int)

val listItems: List<Tracks> = listOf(
    Tracks("Female Super Model Subliminal", image = R.drawable.model_pic1, description ="Become physically attractive" ,0),
    Tracks("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2, description = "Fitness & wellness",1),
    Tracks("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Design your future",2),
    Tracks("Strongest Subliminal Booster v3.1",image = R.drawable.model_pic4, description = "Get faster results",3),
    Tracks("Female Super Model Subliminal",image = R.drawable.model_pic1, description = "Become physically attractive",4),
    Tracks("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2,description="Fitness & wellness",5),
    Tracks("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Get faster results",6),
    Tracks("Strongest Subliminal Booster v3.1",image = R.drawable.model_pic4, description = "Design your future",7),
    Tracks("Female Super Model Subliminal",image = R.drawable.model_pic1, description = "Become physically attractive",8),
    Tracks("Greek God Physique Subliminal v3.1",image = R.drawable.model_pic2,description="Fitness & wellness",9),
    Tracks("The most amazing subliminal for you",image = R.drawable.model_pic3, description = "Get faster results",10),
    Tracks("Female Super Model Subliminal",image = R.drawable.model_pic4, description = "Design your future",11)
)
