import random
race = ["Gnoll","Human","Drow","Aelfir"]
age = ["20s", "30s", "40s", "50s"]
attitude = ["Belligerent", "Kind", "Shifty", "Gruff", "Slow", "Quiet"]
bodyPart = ["Head", "Arms", "Hands", "Legs", "Feet", "Eyes", "Hair", "Skin", "Mouth", "Fingers", "Chest"]
modifier = ["Snake", "Spider", "Moth", "Fly", "Loucust", "Clockwork"]
alteration = ["Extremely flaky skin", "Pale eyes", "Bulging veins", "Extra teeth", "No ears"]


print("A(n) {0} who is in their {1} with a {2} look and a {3} way of speaking."
.format(random.choice(race),random.choice(age),random.choice(attitude),random.choice(attitude)))