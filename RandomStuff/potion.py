import random
colorBad = [" Red"," Blue"," Yellow"," Black"," Clear"," White"]
colorGood = [" Orange"," Purple"," Green"," Brown"]
damage = ["1d8","2d6","2d8","3d6","3d8","4d6"]
statdice = ["1",str(random.randint(1,2)),str(random.randint(1,3)),
str(random.randint(1,4)),str(random.randint(1,5)),str(random.randint(1,6))]
stats = [str(random.choice(statdice))+" Str",str(random.choice(statdice))+" Dex",str(random.choice(statdice))+" Int",
str(random.choice(statdice))+" Wis",str(random.choice(statdice))+" Chr",str(random.choice(statdice))+" Con"]
downside = ["Mute + Deaf","Dex Save DC 10 Trip","Double Step"]
polymorph = ["Dinosaur","Rat","Bird","Yeti","Wolf","Frog"]
transmute = ["Gold","Coal","Iron","Rock","Lava","Water"]
spell = ["Expulsion (10 ft) "+random.choice(damage)+random.choice(colorBad),
"Explosive Rune "+random.choice(damage)+random.choice(colorBad),"Illusion "+random.choice(polymorph)+random.choice(colorBad)
,"Polymorph into a "+random.choice(polymorph)+random.choice(colorGood),
"Transmute material into "+random.choice(transmute)+random.choice(colorBad), 
"Sleep for " + random.choice(statdice) +" hours"+random.choice(colorBad)]
dmgtype = ["Lightning "+random.choice(damage),"Acid "+random.choice(damage),"Psychic, int -1, wis -1 "+random.choice(damage),
"Fire "+random.choice(damage),"Necrotic, con -2 "+random.choice(damage),"Force (10 ft) "+random.choice(damage),
"Radiant "+random.choice(damage),"Cold "+random.choice(damage),"Thunder "+random.choice(damage)]
effect = ["Damage "+random.choice(dmgtype)+random.choice(colorBad),"Stats +"+random.choice(stats)+random.choice(colorGood),
"Downside "+random.choice(downside)+random.choice(colorBad),"Spell "+random.choice(spell),"Heal "+random.choice(colorGood)]
consistancy = ["water-like","quicksilver","syrup","Frozen","Gaseous"]
smell = ["Sweet","Spicy","Savory","Acrid","Burnt Rubber","Salty","Bitter"]


print(random.choice(effect))
print(random.choice(consistancy))
print(random.choice(smell))
