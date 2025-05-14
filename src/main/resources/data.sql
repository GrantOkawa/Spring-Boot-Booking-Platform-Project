INSERT INTO adventures (title, imageUrl, linkUrl, tripCount) VALUES
('Rock Climbing', '/images/adventureProfiles/rockClimbingProfile.jpg', '/adventures-rock-climbing', 4),
('Hiking Tours', '/images/adventureProfiles/hikingProfile.jpg', '/adventures-hiking', 6),
('Backcountry Camping', '/images/adventureProfiles/backcountryProfile.jpg', '/adventures-backcountry-camping', 1);


INSERT INTO destinations (title, subtitle, imageUrl, linkUrl, tripCount) VALUES
('Alberta', 'Hiking Tours', '/images/destinationProfiles/albertaHikeProfile.jpg', '/destination-alberta-hikes', 2),
('Ontario', 'Hiking Tours', '/images/destinationProfiles/ontarioHikeProfile.jpg', '/destination-ontario-hikes', 2),
('British Columbia', 'Hiking Tours', '/images/destinationProfiles/britishColumbiaHikeProfile.jpg', '/destination-british-columbia-hikes', 2),
('Alberta', 'Rock Climbing', '/images/destinationProfiles/albertaRockClimbingProfile.jpg', '/destination-alberta-rock-climbing', 2),
('Ontario', 'Backcountry Camping', '/images/destinationProfiles/ontarioBackcountryProfile.jpg', '/destination-ontario-backcountry-camping', 1),
('British Columbia', 'Rock Climbing', '/images/destinationProfiles/britishColumbiaRockClimbingProfile.jpg', '/destination-british-columbia-rock-climbing', 2);


INSERT INTO guides VALUES
(1, 'Anthony', 'A', 'Rock Climbing Guide', 'guideFour.jpg', 'Anthony has been leading wilderness expeditions for over 7 years across the Pacific Northwest. His expertise in navigation and wilderness first aid ensures safe and educational trips for all participants.', 'Alpine climbing', 7, 'Pacific Crest Trail'),
(2, 'Dara', 'A', 'Hiking Guide', 'guideTwo.jpg', 'As our Northeast Program Manager, Dara coordinates guided trips throughout New England and the Adirondacks. She''s a certified naturalist who loves sharing her knowledge of local flora and fauna.', 'Wildlife tracking', 9, 'Appalachian Trail'),
(3, 'Jack', 'A', 'Hiking Guide', 'guideThree.jpg', 'Jack specializes in desert and canyon exploration. With experience leading trips through the slot canyons of Utah and Arizona, he''s your go-to guide for southwestern adventures.', 'Desert ecology', 5, 'The Narrows, Zion'),
(4, 'Josh', 'A', 'Hiking Guide', 'guideOne.jpg', 'Josh and his trail companion (a friendly Lab named Scout) lead family-friendly hikes focusing on outdoor education for all ages. He''s especially skilled at making hiking fun for newcomers.', 'Family wilderness education', 6, 'Continental Divide Trail'),
(5, 'Rafi', 'A', 'Backcountry Guide', 'guideSix.jpg', 'Rafi is our winter specialist, leading snowshoeing and winter camping expeditions. Her knowledge of cold weather safety and winter navigation keeps adventures going year-round.', 'Winter survival skills', 8, 'John Muir Trail'),
(6, 'Adam', 'B', 'Rock Climbing Guide', 'guideFive.jpg', 'Adam leads our most challenging multi-day expeditions. With experience on three continents and multiple wilderness first responder certifications, he specializes in helping experienced hikers push their limits safely.', 'High-altitude trekking', 12, 'Long Trail, Vermont');


INSERT INTO trips (imageUrl, durationAndPrice, title, location, area, tripType, difficulty, highlights) VALUES
('/images/albertaHikes/albertaHikeOne.jpg', '1 Day from $200', 'Lake Agnes Trail', 'Alberta', 'Banff National Park', 'Day Hike Tour', 3, 'Get to know this 7.4-km out-and-back trail near Lake Louise, Alberta. Generally considered a moderately challenging route, it takes an average of 3h 4min to complete. This is a very popular area for birding, hiking, and running, so you''ll likely encounter other people while exploring. The best times to visit this trail are June through October. Dogs are welcome, but must be on a leash.'),
('/images/albertaHikes/albertaHikeTwo.jpg', '1 Day from $300', 'The Big Beehive', 'Alberta', 'Banff National Park', 'Day Hike Tour', 5, 'Experience this 10.1-km out-and-back trail near Lake Louise, Alberta. Generally considered a challenging route. This is a very popular area for birding, hiking, and snowshoeing, so you''ll likely encounter other people while exploring. The best times to visit this trail are June through October. Dogs are welcome, but must be on a leash.'),
('/images/ontarioHikes/ontarioHikeOne.jpg', '1 Day from $200', 'Track and Tower Trail', 'Ontario', 'Algonquin Provincial Park', 'Day Hike Tour', 3, 'Head out on this 8.0-km loop trail near Nipissing, Ontario. Generally considered a moderately challenging route, it takes an average of 2 h 23 min to complete. This is a very popular area for birding, hiking, and snowshoeing, so you''ll likely encounter other people while exploring. The trail is open year-round and is beautiful to visit anytime. Dogs are welcome, but must be on a leash.'),
('/images/ontarioHikes/ontarioHikeTwo.jpg', '1 Day from $300', 'Niagara Whirlpool Loop', 'Ontario', 'Niagara Glen Nature Reserve', 'Day Hike Tour', 5, 'Get to know this 5.3-km loop trail near Queenston, Ontario. Generally considered a challenging route, it takes an average of 1 h 30 min to complete. This is a very popular area for birding, hiking, and snowshoeing, so you''ll likely encounter other people while exploring. The best times to visit this trail are March through November.'),
('/images/britishColumbiaHikes/britishColumbiaHikeOne.jpg', '1 Day from $200', 'Joffre Lakes', 'British Columbia', 'Joffre Lakes Provincial Park', 'Day Hike Tour', 4, 'Get to know this 7.4-km out-and-back trail near Nesuch 3, British Columbia. Generally considered a challenging route. This is a very popular area for backpacking, camping, and hiking, so you''ll likely encounter other people while exploring. The trail is open year-round and is beautiful to visit anytime. You''ll need to leave pups at home — dogs aren''t allowed on this trail.'),
('/images/britishColumbiaHikes/britishColumbiaHikeTwo.jpg', '1 Day from $200', 'Panorama Ridge', 'British Columbia', 'Garibaldi Provincial Park', 'Day Hike Tour', 5, 'Experience this 28.3-km out-and-back trail near Garibaldi, British Columbia. Generally considered a challenging route. This is a very popular area for backpacking, birding, and camping, so you''ll likely encounter other people while exploring. The trail is open year-round and is beautiful to visit anytime. You''ll need to leave pups at home — dogs aren''t allowed on this trail.'),
('/images/albertaRockClimbing/albertaRockClimbingOne.jpg', '1 Day from $350', 'Brewer Buttress', 'Alberta', 'Banff National Park', 'Guided Rock Climbing', 3, 'Brewer Buttress is an excellent easy multipitch with good rock, great views, a straightforward descent, and fun climbing. All belays are fixed with bolts.'),
('/images/albertaRockClimbing/albertaRockClimbingTwo.jpg', '1 Day from $350', 'East Ridge', 'Alberta', 'Jasper National Park', 'Guided Rock Climbing', 4, 'This is one of the most classic routes the Canadian Rockies and yet another fine FA by the King of Guides, Conrad Kain. The route follows the stunning left skyline of the mountain.'),
('/images/britishColumbiaRockClimbing/britishColumbiaRockClimbingOne.jpg', '2 day from $400', 'Stawamus Chief First, Second, and Third Peak', 'British Columbia', 'Stawamus Chief Provincial Park', 'Guided Rock Climbing', 4, 'Check out this 5.8-km loop trail near Stawamus 24, British Columbia. Generally considered a challenging route. This is a very popular area for camping, hiking, and rock climbing, so you''ll likely encounter other people while exploring. The best times to visit this trail are March through October. Dogs are welcome, but must be on a leash.'),
('/images/britishColumbiaRockClimbing/britishColumbiaRockClimbingTwo.jpg', '2 day from $400', 'Stawamus Chief via Shannon Falls', 'British Columbia', 'Stawamus Chief Provincial Park', 'Guided Rock Climbing', 5, 'Try this 8.0-km out-and-back trail near Squamish, British Columbia. Generally considered a challenging route, it takes an average of 4 h 6 min to complete. This is a very popular area for hiking, rock climbing, and running, so you''ll likely encounter other people while exploring. The best times to visit this trail are April through November. Dogs are welcome, but must be on a leash.'),
('/images/ontarioBackcountryCamping/ontarioBackcountryCampingOne.jpg', '6 Day from $800', 'Wild Algonquin', 'Ontario', 'Algonquin Provincial Park', 'Guided Backcountry Trip', 4, 'Get ready to explore the wilderness of Algonquin Park! Relaxing to the beautiful echo of loon calls, seeing a bull moose or hearing wolf howls at night will provide memories to last a lifetime. Our skilled wilderness guides will enhance your Algonquin Park canoe trip by ensuring your safety, providing back country expertise and humour to your adventure, and knowing the best places to pick fresh berries, fish or photograph moose.');

--Assignment 3 Implementation
INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('user@user.ca', '$2y$10$z.ysZlnWSLYtGVWncYxpfuUpz54TTH/uMGhztQMuq187R6CFcDW16', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('guest@guest.ca', '$2y$10$HKsdIJGbx9E7X8woo.1Zy.BLjrMlQPwcFDc/9HzQcfGP4qK5AbQEu', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('admin@admin.ca', '$2y$10$UbKh5Jpotmm5oplR0B7GNetlqI8X5OEHbodJihYjI9SU44aWTT.46', 1);

 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_GUEST');

INSERT INTO sec_role (roleName)
VALUES ('ROLE_ADMIN');

 
INSERT INTO user_role (userId, roleId)
VALUES (1, 1);
 
INSERT INTO user_role (userId, roleId)
VALUES (2, 2);

INSERT INTO user_role (userId, roleId)
VALUES (3, 3);
