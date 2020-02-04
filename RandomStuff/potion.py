import random
damage = ["1d8","2d6","2d8","3d6","3d8","4d6"]
statdice = ["1",str(random.randint(1,2)),str(random.randint(1,3)),
str(random.randint(1,4)),str(random.randint(1,5)),str(random.randint(1,6))]
stats = [str(random.choice(statdice))+" Str",str(random.choice(statdice))+" Dex",str(random.choice(statdice))+" Int",
str(random.choice(statdice))+" Wis",str(random.choice(statdice))+" Chr",str(random.choice(statdice))+" Con"]
downside = ["Mute + Deaf","Dex Save DC 10 Trip","Double Step"]
polymorph = ["Dinosaur","Rat","Bird","Yeti","Wolf","Frog"]
transmute = ["Gold","Coal","Iron","Rock","Lava","Water"]
spell = ["Expulsion (10 ft) "+random.choice(damage),"Explosive Rune "+random.choice(damage),
"Illusion "+random.choice(polymorph),"Polymorph into a "+random.choice(polymorph),
"Transmute material into "+random.choice(transmute), "Sleep for " + random.choice(statdice) +" hours"]
dmgtype = ["Lightning "+random.choice(damage),"Acid "+random.choice(damage),"Psychic, int -1, wis -1 "+random.choice(damage),
"Fire "+random.choice(damage),"Necrotic, con -2 "+random.choice(damage),"Force (10 ft) "+random.choice(damage),
"Radiant "+random.choice(damage),"Cold "+random.choice(damage),"Thunder "+random.choice(damage)]
effect = ["Damage "+random.choice(dmgtype),"Stats +"+random.choice(stats),
"Downside "+random.choice(downside),"Spell "+random.choice(spell),"Damage "+random.choice(dmgtype)]##
color = ["red","blue","orange","yellow","green","Black","Clear","Milkey White",]
consistancy = ["water-like","quicksilver","syrup","Frozen","Gaseous"]
smell = ["Sweet","Spicy","Savory","Acrid","Burnt Rubber","Salty","Bitter"]


print(random.choice(effect))
print(random.choice(color))
print(random.choice(consistancy))
print(random.choice(smell))
