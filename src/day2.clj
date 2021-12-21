(ns day2
  (:require
    [clojure.string :as string]))



(def day-input
  (->> (slurp "src/day2")
       (string/split-lines)
       (map #(string/split % #" " ))
       (map #(clojure.walk/keywordize-keys {(first %) (Integer/parseInt (second %))}))))


;(defn cords-result
;  [input]
;  (assoc
;    {}
;    :x
;             (apply + (map #(get % :forward 0) input))
;    :y
;            (-(apply + (map #(get % :up 0) input) (map #(get % :down 0) input)))))

;(defn cords-result
;  [input]
;  (assoc
;    {}
;    :x
;    (transduce (map #(get % :forward 0)) + 0 input)
;    :y
;    (- (transduce (map #(get % :up 0)) + 0 input) (transduce (map #(get % :down 0)) + 0 input))))

;(defn cords-result
;  [input]
;  (reduce (fn [res {:keys [forward up down]}]
;            (-> res
;                (update :x + (or forward 0))
;                (update :y + (- (or up 0) (or down 0)))
;                ))
;          {:x 0 :y 0}
;          input))

(defn cords-result
  [input]
  (reduce (fn [res {:keys [forward up down]}]
            (-> res
                (update :x + (or forward 0))
                (update :y + (- (or up 0) (or down 0)))
                (update :z + (* (* '-1 (get res :y )) (or forward 0)))))
          {:x 0 :y 0 :z 0}
          input))



(defn aoc-day2-task2
  [input]
  (->>
    (cords-result input)
    (vals)
    (filter pos-int?)
    (apply *)
    ))

(defn aoc-day2-task1 [input]
  (apply *
    (vals (cords-result input ))
    ))



(aoc-day2-task2 day-input)






(comment








  )